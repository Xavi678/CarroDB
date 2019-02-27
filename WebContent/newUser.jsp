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
	 <s:form action="nouProducte.action" validate="true" >
	  <s:textfield key="newUser.nom" name="producte.nom" />
	 <s:textfield key="newUser.dispo" name="producte.disponibilitat" />
	 <s:textfield key="newUser.descripcio"  name="producte.descripcio" />
	 <s:textfield key="newUser.preu"  name="producte.preu" />
	 
     
      <s:submit name="submit" key="global.save" align="center" />
   </s:form>
	
</body>
</html>