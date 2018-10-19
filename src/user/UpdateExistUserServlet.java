package user;

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
 
import user.User;

@WebServlet(name="updateexistuser", urlPatterns={"/updateexistuser"})
public class UpdateExistUserServlet extends HttpServlet {
	
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
		int userid = Integer.parseInt(req.getParameter("userid").trim());
		String username = req.getParameter("username");
		int sex = Integer.parseInt(req.getParameter("sex"));
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String comment = req.getParameter("comment");
		int isdelete = Integer.parseInt(req.getParameter("isdelete"));
		
		System.out.print(userid+sex+isdelete);
		
		String errMsg="";
	    
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
	        ps = conn.prepareStatement("update user_detail set username = '"+username+"', sex= "+sex+",phone = '"+phone+"', email = '"+email+"', address = '"+address+"', comment= '"+comment+"', isdelete = "+isdelete+" where id ="+userid+"");
			
			int i = ps.executeUpdate();
			if(i==1) {
				errMsg="更新用户信息成功";
			}else {
				errMsg="更新用户信息失败";
			}
			//System.out.println(errMsg);
			req.setAttribute("err", errMsg);
			req.getRequestDispatcher("UserManage/member-update.jsp").forward(req, resp);
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
