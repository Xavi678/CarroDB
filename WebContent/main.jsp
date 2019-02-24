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
		<jsp:param name="menuActual" value="llistar.action"/>
	</jsp:include>

	<table width="100%">
			<!-- capcalera -->
			<tr><th colspan="4"><s:text name="llistat.llistatProductes" /></th></tr>
			<tr bgcolor="grey"><th><b><s:text name="llistat.nom" /></b></th><th><b><s:text name="llistat.dispo" /></b></th><th><b><s:text name="llistat.descripcio" /></b></th><th><b><s:text name="llistat.preu" /></b></th>
	
	<s:iterator value="productes" var="usuari" status="rowstatus">
	 			<!-- Pintem els parells diferent dels imparells -->
	 			<s:if test="#rowstatus.odd == true"><tr bgcolor="Aqua"></s:if>
            	<s:else><tr></s:else>
            	<!-- Anem a llistar un usuari -->
            	
            	<td align="center"><s:property value="nom"/></td>
            	<td align="center"><s:property value="disponibilitat"/></td>
            	<!--  <td align="center"><s:property value="%{getText('global.date',{dataNaixement})}"/></td>	-->
            	<td align="center"><s:property value="descripcio"/></td>
            	<td align="center"><s:property value="preu"/></td>
            	
    </s:iterator>
   <!--   <a href="<s:url action="logOut"/>">Log out</a>-->
	
	

</body>
</html>