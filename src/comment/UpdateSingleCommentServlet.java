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
 
import comment.Comments;

@WebServlet(name="updatesinglecomment", urlPatterns={"/updatesinglecomment"})
public class UpdateSingleCommentServlet extends HttpServlet {
	
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
		
		//获取参数
		req.setCharacterEncoding("UTF-8");
		int commentid = Integer.parseInt(req.getParameter("commentid").trim());
		String email = req.getParameter("email");
		String comment = req.getParameter("comment");
		int isdelete = Integer.parseInt(req.getParameter("isdelete"));
		
		//System.out.print(userid);
		
		String errMsg="";
	    
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
	        ps = conn.prepareStatement("update comment set comments_email = '"+email+"' , comments_content = '"+comment+"' , comments_status = "+isdelete+" where id ="+commentid+"");
			
			int i = ps.executeUpdate();
			if(i==1) {
				errMsg="更新评论成功";
			}else {
				errMsg="更新评论失败";
			}
			System.out.println(errMsg);
			req.setAttribute("err", errMsg);
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
