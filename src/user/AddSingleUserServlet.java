package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import index.DbDao;
import user.User;

@WebServlet(name="addsingleuser", urlPatterns={"/addsingleuser"})
public class AddSingleUserServlet extends HttpServlet {
	
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
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
	    String password = req.getParameter("password");
		int sex = Integer.parseInt(req.getParameter("sex").trim());
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address =req.getParameter("address");
		String comment = req.getParameter("comment");
		String errMsg="";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
	    
		try {
			DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/managesystem",
	                "root", "root");
	        ResultSet rs = dd.query("select password from login where username = ?", username);
	        if(rs.next()) {
	            errMsg += "用户名已存在";
	        }else {
	            boolean addUser = dd.insert("insert into login(username, password) values(?, ?)",username, password) && dd.insert("insert into user_detail(username, sex, password, phone, email, address,registtime,comment) values(?, ?, ?, ?,?, ?, ?,?)",username, sex, password, phone, email, address,date,comment);
	            if(!addUser) {
	                errMsg += "娣诲姞鐢ㄦ埛澶辫触";
	            }
	            req.setAttribute("err", errMsg);
				req.getRequestDispatcher("UserManage/member-add.jsp").forward(req, resp);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
