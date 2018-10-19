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
 
import news.News;

@WebServlet(name="getsinglenews", urlPatterns={"/getsinglenews"})
public class GetSingleNewsServlet extends HttpServlet {
	
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
		String errMsg = "";
		int userid = Integer.parseInt(req.getParameter("userid").trim());
	    
		try {
			List<News> newsList = new ArrayList<>();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
	        ps = conn.prepareStatement("select * from partcontent where id ='"+userid+"'");
			
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String brief_intro = rs.getString("brief_intro");
				String type = rs.getString("type");
				String pic = rs.getString("pic");
				String content = rs.getString("content");
				String jsp = rs.getString("jsp");
				String writer = rs.getString("writer");
				String part = rs.getString("part");
				int status = rs.getInt("status");
				String time = rs.getString("time");
				News news = new News(id,title,brief_intro,type,pic,content,jsp,writer,part,status,time);
				newsList.add(news);
			}
			req.setAttribute("newsList", newsList);
			req.getRequestDispatcher("NewsManage/news-update.jsp").forward(req, resp);
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
