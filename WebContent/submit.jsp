<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.LinkedList" import="p1.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
LinkedList<Questions> l=(LinkedList)session.getAttribute("ls");
String s=(String)session.getAttribute("name");
System.out.println(s);
Player p=new Player(s);
p.setName(s);
for(int i=0;i<l.size();i++)
{%><%=l.get(i).getAns()%>
<%=l.get(i).getUserans()%>
<%
	if(l.get(i).getAns().equals(l.get(i).getUserans()))
	{
		System.out.println(p.getScore());
		p.setScore(p.getScore()+1);
	}
}

%><br><br><br>

<h3><%=p.getName() %></h3>

<% 
int sc=p.getScore();%>
<h3>Your Score is :<%=sc %> </h3>
<%new DataBase("quiz").insertPlayer(p);
%>

</body>
</html>