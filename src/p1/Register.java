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

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LinkedList<Questions> l=new LinkedList<Questions>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String s1=request.getParameter("name");
		session.setAttribute("name", s1);		
		DataBase ob=new DataBase("quiz");
		l=ob.get();
		session.setAttribute("ls",l);
		session.setAttribute("j",0);
		RequestDispatcher rd=request.getRequestDispatcher("exam.jsp");  
        rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
