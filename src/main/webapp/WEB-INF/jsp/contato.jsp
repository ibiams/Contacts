<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Contatos</title>
</head>
<body>
   <h2>${contato.nome}</h2>
   <div>Email: ${contato.email}</div>
   <table border="1">
   <div>Telefones:</div>
	  <c:forEach var="telefone" items="${contato.telefones}" varStatus="id">
	    <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
	      <td>${telefone.numero}</td>
	    </tr>
	  </c:forEach>
	</table>
	
	<a href="http://localhost:8080/contatos/deletar-contato?id=${contato.id}"><button class="btn">Deletar</button></a>
	<a href="http://localhost:8080/contatos/atualizar?id=${contato.id}"><button class="btn">Atualizar</button></a>
	
</body>
</html>