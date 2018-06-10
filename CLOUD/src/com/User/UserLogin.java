package com.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.AdminBean;
import com.Bean.UserBean;
import com.Implementation.Implementation;
import com.Interfaces.Interface;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String password=request.getParameter("password");
		
		UserBean bean=new UserBean();
		bean.setId("");
		bean.setUid(uid);
		bean.setPassword(password);
		
		HttpSession session=request.getSession();  
        
        session.setAttribute("uid",uid); 
  
		
		Interface i=new Implementation();
		String result=i.userLogin(bean);
		session.setAttribute("uname",result); 
		if(result == null)
		{
			
			
		     response.setContentType("text/html");  
			out.println("<html>");
	
			out.println("<body> ");
		
			
	
		
			out.println("<center><h2>Invalid ID or Password...<a href=user.html> Try again</a><h2></center>");
			
		
			out.println("</body></html>");
			
		}
		else
		{
			response.sendRedirect("user_welcome.jsp");
		}
		
		
	}

}
