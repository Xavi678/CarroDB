<%@page import="almata.daw.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%">
	<tr>
		<%
		
 	String menuActual=request.getParameter("menuActual");
	for(int i=0;i<Constants.menuCode.length;i++){
		out.print("<td>");
		if(menuActual!=null && !menuActual.equals(Constants.menuCode[i])){
			out.print("<a href=\""+Constants.menuCode[i]+"\">"+Constants.menuString[i]+"</a>");
			
		}else{
			out.print(Constants.menuString[i]);
		}
		out.print("</td>");
	}
	%>
	</tr>
</table>
</body>
</html>