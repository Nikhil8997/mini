package com.Attacker;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Bean;
import com.Implementation.Implementation;
import com.Interface.Interfaces;

/**
 * Servlet implementation class Attack
 */
@WebServlet("/Attack")
public class Attack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String location=request.getParameter("location");
		System.out.println(id);
		Bean bean=new Bean();
		bean.setId(id);
		bean.setLocation(location);
		Interfaces i=new Implementation();
		response.sendRedirect("fileViews.jsp");
		/*int result=i.attack(bean);
		if(result==1){
			response.sendRedirect("attack.html");
		}else
		{
			response.sendRedirect("error.html");
		}*/
		
	}

}
