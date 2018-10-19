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
        
        ResultSet rs = dd.query("select password from login where username = ?", username);
        if(rs.next()){
            if(rs.getString("password").equals(pass)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("name", username); 
                rd = request.getRequestDispatcher("index.jsp"); 
                rd.forward(request, response);
            }else{
                errMsg += "密码错误，请重新输入";
            }
        }else{
            errMsg += "该用户不存在";
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