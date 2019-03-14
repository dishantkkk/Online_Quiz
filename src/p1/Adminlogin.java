package p1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Admin ob=new Admin();
			HttpSession session=request.getSession();
			ob.setName(request.getParameter("name"));
			ob.setPswrd(request.getParameter("password"));
			boolean flag=new DataBase("quiz").checkAd(ob);
			if(flag==false)
			{
			 session.setAttribute("label","ERROR!!! Wrong Username or Password!! Please enter valid username or password");
			 RequestDispatcher rd=request.getRequestDispatcher("admin.html");  
		        rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("admsuccess.html");  
		        rd.forward(request, response);
			}
	}
}
