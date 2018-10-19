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

@WebServlet(name="getexistuser", urlPatterns={"/getexistuser"})
public class GetExistUserListServlet extends HttpServlet {
	
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
		
		resp.setCharacterEncoding("utf-8");
		String username = req.getParameter("username").trim();
	    String phone = req.getParameter("phone").trim();
	    String email = req.getParameter("email").trim();
	    
	    if(username==null) {
	    	username="";
	    }
	    if(phone==null) {
	    	phone="";
	    }
	    if(email==null) {
	    	email="";
	    }
	    
		try {
			List<User> userList = new ArrayList<>();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
			if(username=="" && phone=="" && email==""){
		        // 查询结果集
		        ps = conn.prepareStatement("select * from user_detail where isdelete=0 or isdelete=1");
	        }else if(username!="" && phone=="" && email==""){
	        	ps = conn.prepareStatement("select * from user_detail where username like '"+"%"+username+"%"+"' and isdelete=0 or isdelete=1");
	        }else if(username=="" && phone!="" && email==""){
	        	ps = conn.prepareStatement("select * from user_detail where phone like '"+"%"+phone+"%"+"' and isdelete=0 or isdelete=1");
	        }else if(username=="" && phone=="" && email!=""){
	        	ps = conn.prepareStatement("select * from user_detail where email like '"+"%"+email+"%"+"' and isdelete=0 or isdelete=1");
	        }else if(username!="" && phone!="" && email==""){
	        	ps = conn.prepareStatement("select * from user_detail where username like '"+"%"+username+"%"+"' and phone like '"+"%"+phone+"%"+"' and isdelete=0 or isdelete=1");
	        }else if(username!="" && phone=="" && email!=""){
	        	ps = conn.prepareStatement("select * from user_detail where username like '"+"%"+username+"%"+"' and email like '"+"%"+email+"%"+"' and isdelete=0 or isdelete=1");
	        }else if(username=="" && phone!="" && email!=""){
	        	ps = conn.prepareStatement("select * from user_detail where phone like '"+"%"+phone+"%"+"' and email like '"+"%"+email+"%"+"' and isdelete=0 or isdelete=1");
	        }else if(username!="" && phone!="" && email!=""){
	        	ps = conn.prepareStatement("select * from user_detail where username like '"+"%"+username+"%"+"' and phone like '"+"%"+phone+"%"+"' and email like '"+"%"+email+"%"+"' and isdelete=0 or isdelete=1");
	        }
			
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("username");
				String password = rs.getString("password");
				int sex = rs.getInt("sex");
				String pho = rs.getString("phone");
				String ema = rs.getString("email");
				String address = rs.getString("address");
				String registtime = rs.getString("registtime");
				String comment = rs.getString("comment");
				int isdelete = rs.getInt("isdelete");
				User user = new User(id,name,password,sex,pho,ema,address,registtime,comment,isdelete);
				userList.add(user);
			}
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("member-list.jsp").forward(req, resp);
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
