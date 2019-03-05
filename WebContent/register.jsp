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
<s:actionmessage/>
<s:form action="Register.action">
 
      <s:textfield key="newUser.login" name="usuari.login"/>
      <s:textfield key="newUser.passwd" type="password" name="usuari.password"/>
   	<s:textfield  key="newUser.passwd" type="password" name="usuari.password2"/>
      <s:submit name="submit" key="global.save" align="center" />
   </s:form>
   <a href="login.jsp">Tornar</a>
</body>
</html>