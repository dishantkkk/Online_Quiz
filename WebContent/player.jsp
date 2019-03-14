<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.sql.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Score</title>
</head>
<body>
<% 
Connection conn = null;
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/";
String db = "quiz";
String user = "root";
String pass = "";
Statement st = null;
ResultSet rs = null;
try {

Class.forName(driver);
conn = DriverManager.getConnection(url+db,user,pass);

st = conn.createStatement();
rs = st.executeQuery("select * from players");
%>
<br><br>
<center>
<table border="1">
<tr>
<th style="width:100px;height:20px;">Name</th>
<th style="width:100px;height:20px;">Score</th>
</tr>
<% 
String s;
int n;
while(rs.next())
{
s=rs.getString(1);
n=rs.getInt(2);
%>
<tr>
<td style="width:100px;height:20px;"><%=s %></td>
<td style="width:100px;height:20px;"><%=n %></td>
</tr>
<%} %>
</table>
</center>
<% }
catch (Exception ex) {
ex.printStackTrace();
%>
<div align="left"><a href="admsuccess.html"><button type="button">Back</button></a></div>
<%
} finally {
if (rs != null) rs.close();
if (st != null) st.close();
if (conn != null) conn.close();
}
%>

</body bgcolor="#e4e4fa">
</html>