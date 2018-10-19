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

import comment.Comments;

@WebServlet(name="getsinglecomment", urlPatterns={"/getsinglecomment"})
public class GetSingleCommentServlet extends HttpServlet {
	
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
		int userid = Integer.parseInt(req.getParameter("commentid").trim());
	    
		try {
			List<Comments> commentList = new ArrayList<>();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
	        ps = conn.prepareStatement("select * from comment where id ='"+userid+"'");
			
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String comments_name = rs.getString("comments_name");
				String comments_email = rs.getString("comments_email");
				String comments_content = rs.getString("comments_content");
				String comments_time = rs.getString("comments_time");
				int comments_status = rs.getInt("comments_status");
				Comments comments = new Comments(id,comments_name,comments_email,comments_content,comments_time,comments_status);
				commentList.add(comments);
			}
			req.setAttribute("commentList", commentList);
			req.getRequestDispatcher("CommentManage/comment-update.jsp").forward(req, resp);
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
