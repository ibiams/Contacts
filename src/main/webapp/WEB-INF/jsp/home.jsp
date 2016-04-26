<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<title>Contatos</title>
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/bootstrap/js/example.js" />"></script>
</head>
<body>
	
   	<h2>Lista de Contatos</h2>
   	<table border="1" class="table table-striped">
   	  <tr>
   	  <td></td><td>Nome</td><td>Numero</td>
   	  </tr>
	  <c:forEach var="contato" items="${contatos}" varStatus="id">
	    <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
	      <td>${id.count}</td><td><a href="http://localhost:8080/contatos/detalhar-contato?id=${contato.id}">${contato.nome}</a></td><td> <c:if test="${fn:length(contato.telefones) gt 0}"> ${contato.telefones.get(0).numero} </c:if> </td>
	    </tr>
	  </c:forEach>
	</table>
	
	<a href="http://localhost:8080/contatos/adicionar"><button class="btn">Novo Contato</button></a>
	
	<script src="<c:url value="/resources/bootstrap/js/example.js" />"></script>
</body>
</html>	