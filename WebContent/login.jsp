<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:actionerror/>
<s:form action="LoginUser.action">
 
      <s:textfield key="newUser.login" name="usuari.login"/>
      <s:textfield key="newUser.passwd" type="password" name="usuari.password"/>
   
      <s:submit name="submit" key="global.save" align="center" />
   </s:form>
<a href="register.jsp">Registrar-se</a>
</body>
</html>