package index;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="login", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String errMsg = "";
    RequestDispatcher rd;
    String username = request.getParameter("username");
    String pass = request.getParameter("password");
    try {
        DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/managesystem",
                "root", "root");
        
        ResultSet rs = dd.query("select password,isdelete from user_detail where username = ?", username);
        if(rs.next()){
        	if(rs.getInt("isdelete")==0) {
        		if(rs.getString("password").equals(pass)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("name", username); 
                    /*rd = request.getRequestDispatcher("index.jsp"); 
                    rd.forward(request, response);*/
                    response.sendRedirect("index.jsp");
                }else{
                    errMsg += "�����������������";
                }
        	}else if(rs.getInt("isdelete")==1){
        		errMsg += "���û��ѽ��ã�������ѯ����Ա";
        	}else if(rs.getInt("isdelete")==2) {
        		errMsg += "���û���ɾ����������ѯ����Ա";
        	}
        }else{
            errMsg += "���û�������";
        }
    }catch(Exception e) {
        e.printStackTrace();
    }

    if(errMsg != null && !errMsg.equals("")){
        rd = request.getRequestDispatcher("login.jsp");
        request.setAttribute("err", errMsg);
        rd.forward(request, response);
    }
    }
}