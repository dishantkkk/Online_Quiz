<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.LinkedList" import="p1.Questions"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#000000" style="color:#ffffff;font-size:30px;">
<%Questions q=new Questions();
//String s = (String)session.getAttribute("name");
LinkedList<Questions> ld=(LinkedList<Questions>)session.getAttribute("ls");
int j=(int)session.getAttribute("j");
String s=(String)session.getAttribute("name");
session.setAttribute("name", s);
%>
<br><br><br>
<center>
<form method="get">
Question :<br><br>

	<%=ld.get(j).getQues() %><br><br>
	a) <input type="radio" name="option" value="<%=ld.get(j).getOp1() %>"><%=ld.get(j).getOp1() %><br>
	b) <input type="radio" name="option" value="<%=ld.get(j).getOp2() %>"><%=ld.get(j).getOp2() %><br>
	c) <input type="radio" name="option" value="<%=ld.get(j).getOp3() %>"><%=ld.get(j).getOp3() %><br>
	d) <input type="radio" name="option" value="<%=ld.get(j).getOp4() %>"><%=ld.get(j).getOp4() %><br><br><br>
	
	<%
	ld.get(j).getAns();
	if(j!=0)
	{%>
		<input type="submit" value="Previous" formaction="./back" style="height:40px;width:180px;font-size:22px;"></input>
	<%}
	if(j!=ld.size()-1)
	{
	%>
		<input type="submit" value="Next" formaction="./next1" style="height:40px;width:180px;font-size:22px;"></input>
	<%}
	else{%><br>
	<div align="right"><input type="submit" formaction="./next1" style="height:40px;width:180px;font-size:22px;"></input></div><br>
	<%} %>
</form></center>
</body>
</html>