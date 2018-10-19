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
 
import user.User;

@WebServlet(name="updateexistnews", urlPatterns={"/updateexistnews"})
public class UpdateExistNewsServlet extends HttpServlet {
	
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
		int newsid = Integer.parseInt(req.getParameter("newsid").trim());
		String title = req.getParameter("title");
		String brief_intro = req.getParameter("brief_intro");
		String type = req.getParameter("type");
		String pic = req.getParameter("uploadfile1");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String part = req.getParameter("part");
		int status = Integer.parseInt(req.getParameter("status"));
		
		//System.out.print(newsid);
		
		String errMsg="";
	    
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
	        ps = conn.prepareStatement("update partcontent set title = '"+title+"', brief_intro = '"+brief_intro+"', type = '"+type+"',pic = '"+pic+"', content= '"+content+"', writer = '"+writer+"', part = '"+part+"', status = "+status+" where id ="+newsid+"");
			
			int i = ps.executeUpdate();
			if(i==1) {
				errMsg="更新用户信息成功";
			}else {
				errMsg="更新用户信息失败";
			}
			System.out.println(errMsg);
			req.setAttribute("err", errMsg);
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
