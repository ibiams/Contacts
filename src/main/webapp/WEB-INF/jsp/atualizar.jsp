<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Contatos</title>
</head>
<body>
	<h2>Dados do Contato</h2>
	<form:form method="POST" action="atualizarContato">
		<div>Nome: <form:input path="nome" type="text" value="${contato.nome}"/></div>
		<div>Email: <form:input path="email" type="text" value="${contato.email}"/></div>
		<div>
			<div>Telefones:</div>
			<form:input path="telefones[0].numero" type="text" />
			<form:input path="telefones[0].id" type="hidden" value="${contato.telefones.get(0).id}"/>
			<form:input path="telefones[1].numero" type="text" />
			<form:input path="telefones[1].id" type="hidden" value="${contato.telefones.get(1).id}"/>
			<form:input path="telefones[2].numero" type="text" />
			<form:input path="telefones[2].id" type="hidden" value="${contato.telefones.get(2).id}"/>
			<form:input path="id" type="hidden" value="${contato.id}"/>
		</div>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>