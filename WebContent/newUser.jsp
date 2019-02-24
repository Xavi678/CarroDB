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
		<jsp:param name="menuActual" value="nouUsuari.action"/>
	</jsp:include>
	 <s:actionerror/>
	 <s:form action="nouUsuari.action" validate="true" >
	  <s:textfield key="newUser.login" name="producte.nom" />
	 <s:textfield key="newUser.nom" name="producte.disponbilitat" />
	 <s:textfield key="newUser.passwd"  name="producte.descripcio" />
	 <s:textfield key="newUser.passwd"  name="producte.preu" />
	 
     
      <s:submit name="submit" key="global.save" align="center" />
   </s:form>
	
</body>
</html>