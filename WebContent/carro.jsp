<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1{

text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="menuActual" value="llistar.action"/>
	</jsp:include>
	<h1><s:text name="llistat.llistatCarro" /></h1>
<s:form action="Comprar.action">	
	<table width="100%">
			<!-- capcalera -->
			
			<tr bgcolor="grey"><th><b><s:text name="llistat.nom" /></b></th><th><b><s:text name="llistat.dispo" /></b></th><th><b><s:text name="llistat.descripcio" /></b></th><th><b><s:text name="llistat.preu" /></b></th> <th><b><s:text name="llistat.propietari" /></b></th><th><b><s:text name="llistat.afegir" /></b></th>

	<s:iterator value="carro" var="car" status="rowstatus">
	 			<!-- Pintem els parells diferent dels imparells -->
	 			<s:if test="#rowstatus.odd == true"><tr bgcolor="Aqua"></s:if>
            	<s:else><tr></s:else>
            	<!-- Anem a llistar un usuari -->
            	
            	<td align="center"><s:property value="nom"/></td>
            	<td align="center"><s:property value="disponibilitat"/></td>
            	<!--  <td align="center"><s:property value="%{getText('global.date',{dataNaixement})}"/></td>	-->
            	<td align="center"><s:property value="descripcio"/></td>
            	<td align="center"><s:property value="preu"/></td>
<%--             	<td align="center"><s:property value="propietari"/></td> --%>
            	<td><s:checkbox name="checkboxes[%{#rowstatus.index}]" theme="simple" /></td>
            	<s:hidden value="%{productes.nom}"/>
            	
    </s:iterator>
   
    <s:submit name="submit" key="global.comprar" align="center" /> 
   </s:form>
   <!--   <a href="<s:url action="logOut"/>">Log out</a>-->
	
	

</body>
</html>