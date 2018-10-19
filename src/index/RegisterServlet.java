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

@WebServlet(name="register", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String errMsg = "";
    RequestDispatcher rd;
    String username = request.getParameter("username");
    String pass = request.getParameter("password");
    String conPass = request.getParameter("repassword");
    
    if((username.length()==0)|| (pass.length()==0)||!pass.equals(conPass))
        errMsg += "ע��ʧ�ܣ������û���������ǿգ���ȷ������һ��";

    else {
        try {
            DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/managesystem",
                    "root", "root");
            ResultSet rs = dd.query("select password from login where username = ?", username);
            if(rs.next()) {
                errMsg += "�û��Ѿ����ڣ������������û���";
            }
            else {
                boolean addUser = dd.insert("insert into login(username, password) values(?, ?)",username, pass);
                if(!addUser) {
                    errMsg += "ע���û����ִ���";
                }
                
                // ע��ɹ���ת����login.jsp
                HttpSession session = request.getSession(true);
                session.setAttribute("name", username);
                
                //��ȡת������
                rd = request.getRequestDispatcher("login.jsp");
                
                // ת������
                rd.forward(request, response);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    // �������ת��������ע��
    if(errMsg != null && !errMsg.equals("")){
        rd = request.getRequestDispatcher("register.jsp");
        request.setAttribute("err", errMsg);
        rd.forward(request, response);
    }
    }
}