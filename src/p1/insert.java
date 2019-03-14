package p1;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ques=request.getParameter("t1");
		String op1=request.getParameter("t2");
		String op2=request.getParameter("t3");
		String op3=request.getParameter("t4");
		String op4=request.getParameter("t5");
		String correct=request.getParameter("t6");
		Questions ob=new Questions();
		System.out.println(ques+","+op1+","+op2+","+op3+","+op4+","+correct);
		ob.setQues(ques);
		ob.setOp1(op1);
		ob.setOp2(op2);
		ob.setOp3(op3);
		ob.setOp4(op4);
		ob.setAns(correct);
		System.out.println(ob.getQues());
		System.out.println(ob.getOp1());
		System.out.println(ob.getOp2());
		System.out.println(ob.getOp3());
		System.out.println(ob.getOp4());
		System.out.println(ob.getAns());
		DataBase db=new DataBase("quiz");
		db.insert(ob);
		PrintWriter out=response.getWriter();
		out.println("For adding another question click button");
		RequestDispatcher rd=request.getRequestDispatcher("admsuccess.html");  
        rd.forward(request, response);
	}

}
