package comment;

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

@WebServlet(name="getcommentlist", urlPatterns={"/getcommentlist"})
public class GetCommentListServlet extends HttpServlet {
	
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
		String username = req.getParameter("username").trim();
	    String comment = req.getParameter("comment").trim();
	    String comments_time = req.getParameter("comments_time").trim();
	    
	    if(username==null) {
	    	username="";
	    }
	    if(comment==null) {
	    	comment="";
	    }
	    if(comments_time==null) {
	    	comments_time="";
	    }
	    
		try {
			List<Comments> commentlist = new ArrayList<>();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
			if(username=="" && comment=="" && comments_time==""){
		        // 查询结果集
		        ps = conn.prepareStatement("select * from comment");
	        }else if(username!="" && comment=="" && comments_time==""){
	        	ps = conn.prepareStatement("select * from comment where username ='"+username+"'");
	        }else if(username=="" && comment!="" && comments_time==""){
	        	ps = conn.prepareStatement("select * from comment where comments_content ='"+comment+"'");
	        }else if(username=="" && comment=="" && comments_time!=""){
	        	ps = conn.prepareStatement("select * from comment where comments_content ='"+comment+"'");
	        }else if(username!="" && comment!="" && comments_time==""){
	        	ps = conn.prepareStatement("select * from comment where username ='"+username+"' and comments_content ='"+comment+"'");
	        }else if(username!="" && comment=="" && comments_time!=""){
	        	ps = conn.prepareStatement("select * from comment where username ='"+username+"' and comments_time ='"+comments_time+"'");
	        }else if(username=="" && comment!="" && comments_time!=""){
	        	ps = conn.prepareStatement("select * from comment where comments_content ='"+comment+"' and comments_time='"+comments_time+"'");
	        }else if(username!="" && comment!="" && comments_time!=""){
	        	ps = conn.prepareStatement("select * from comment where username ='"+username+"' and comments_content ='"+comment+"' and comments_time='"+comments_time+"'");
	        }
			
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String comments_name = rs.getString("comments_name");
				String comments_email = rs.getString("comments_email");
				String comments_content = rs.getString("comments_content");
				String comments_tm = rs.getString("comments_time");
				int comments_status = rs.getInt("comments_status");
				Comments comments = new Comments(id,comments_name,comments_email,comments_content,comments_tm, comments_status);
				commentlist.add(comments);
			}
			req.setAttribute("commentlist", commentlist);
			req.getRequestDispatcher("comment-list.jsp").forward(req, resp);
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
