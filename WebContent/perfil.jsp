<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="menuActual" value="perfil.action"/>
	</jsp:include>
	
	
 <s:label key="newUser.login"/> <s:property value="usuari.login"  /><br>
 <s:form action="canviar.action">
  <s:textfield key="newUser.passwd" name="usuari.password" value="%{usuari.password}"/>
  <s:submit key="global.change"></s:submit>
  </s:form>
</body>
</html>