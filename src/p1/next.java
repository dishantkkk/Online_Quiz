package p1;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class next extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int j=(int)session.getAttribute("j"); 
		String ans=(String)request.getParameter("option");
		System.out.println(ans);
		LinkedList<Questions> ld=(LinkedList<Questions>)session.getAttribute("ls");
		ld.get(j).setUserans(ans);
		session.setAttribute("j",j+1);
		if(j==ld.size()-1)
		{
			RequestDispatcher rd=request.getRequestDispatcher("submit.jsp");  
	        rd.forward(request, response);
		}
		else
		{
		RequestDispatcher rd=request.getRequestDispatcher("exam.jsp");  
        rd.forward(request, response);
		}
	}

}
