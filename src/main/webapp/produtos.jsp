<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="model.JavaBeans" %>
    <%@page import="java.util.ArrayList" %>
    
    <%
    	@ SuppressWarnings("unchecked")
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista de Produtos</title>
</head>
<body>
	<h1>Lista de Produtos Cadastrados</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Código</th>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Valor</th>
				<th>Quantidade</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i=0; i<lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getId() %></td>
					<td><%=lista.get(i).getCodigo() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getCategoria() %></td>
					<td><%=lista.get(i).getValor() %></td>
					<td><%=lista.get(i).getQuantidade() %></td>
					<td>
						<a href="javascript: confirmarExclusao(<%=lista.get(i).getId()%>)">Excluir</a>
						<a href="select?id=<%=lista.get(i).getId()%>">Editar</a>
					</td>
					
				</tr>
				<%} %>
		</tbody>
	</table>
	<p>
	<a href="create">Cadastrar Aluno</a>
	<p>
	<a href="home">Sair</a>
	<script src="scripts/confirmador.js"></script>
</body>
</html>