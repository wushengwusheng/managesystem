package news;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;

import comment.Comments;;

@WebServlet(name="getnewslist", urlPatterns={"/getnewslist"})
public class GetNewsListServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String title = req.getParameter("title").trim();
	    String brief_intro = req.getParameter("brief_intro").trim();
	    
	    if(title==null) {
	    	title="";
	    }
	    if(brief_intro==null) {
	    	brief_intro="";
	    }
	    
		try {
			List<News> newsList = new ArrayList<>();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
			if(title=="" && brief_intro==""){
		        // 查询结果集
		        ps = conn.prepareStatement("select * from partcontent");
	        }else if(title!="" && brief_intro==""){
	        	ps = conn.prepareStatement("select * from partcontent where title like '"+"%"+title+"%"+"'");
	        }else if(title=="" && brief_intro!=""){
	        	ps = conn.prepareStatement("select * from partcontent where brief_intro like '"+"%"+brief_intro+"%"+"'");
	        }else if(title!="" && brief_intro!=""){
	        	ps = conn.prepareStatement("select * from partcontent where title like '"+"%"+title+"%"+"' and brief_intro like '"+"%"+brief_intro+"%"+"'");
	        }
			
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String tit = rs.getString("title");
				String brief = rs.getString("brief_intro");
				String type = rs.getString("type");
				String pic = rs.getString("pic");
				String content = rs.getString("content");
				String jsp = rs.getString("jsp");
				String writer = rs.getString("writer");
				String part = rs.getString("part");
				int goods_count = rs.getInt("goods_count");
				int comment = rs.getInt("comment");
				int view = rs.getInt("view");
				int status = rs.getInt("status");
				String time = rs.getString("time");
				News news = new News(id,tit,brief,type,pic,content,jsp,writer,part,goods_count,comment,view,status,time);
				newsList.add(news);
			}
			req.setAttribute("newsList", newsList);
			req.getRequestDispatcher("news-list.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
