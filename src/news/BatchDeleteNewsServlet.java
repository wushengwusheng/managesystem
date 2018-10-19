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

@WebServlet(name="batchdeletenews", urlPatterns={"/batchdeletenews"})
public class BatchDeleteNewsServlet extends HttpServlet {
	
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
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//��ȡ����
		req.setCharacterEncoding("UTF-8");
		String userid = req.getParameter("userid").trim();
		//String page = req.getParameter("page").trim();
		
		System.out.print(userid);
		
		String errMsg="";
	    
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem","root","root");
			
	        ps = conn.prepareStatement("update partcontent set status = 3 where id in ("+userid+")");
			
			int i = ps.executeUpdate();
			if(i!=0) {
				errMsg="ɾ����Ѷ�ɹ�";
			}else {
				errMsg="ɾ����Ѷʧ��";
			}
			//System.out.println(errMsg);
			req.setAttribute("err", errMsg);
			/*if(page.equals("/manage/getexistuser")) {
				req.getRequestDispatcher("member-list.jsp").forward(req, resp);
			}else if(page.equals("/manage/getdeluser")){
				req.getRequestDispatcher("member-dellist.jsp").forward(req, resp);
			}*/
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
}
