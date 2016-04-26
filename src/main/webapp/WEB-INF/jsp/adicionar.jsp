<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Contatos</title>
</head>
<body>
	<h2>Dados do Contato</h2>
	<form:form method="POST" action="adicionarContato">
		<div>Nome: <form:input path="nome" type="text" /></div>
		<div>Email: <form:input path="email" type="email"/></div>
		<div>
			<div>Telefones:</div>
			<form:input path="telefones[0].numero" type="text" />
			<form:input path="telefones[1].numero" type="text" />
			<form:input path="telefones[2].numero" type="text" />
		</div>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>