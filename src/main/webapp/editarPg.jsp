<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>

<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista de Produtos</title>
<link rel="stylesheet" href="style.css">
<script src="scripts/confirmador.js"></script>
</head>
<body>
	<main>
		<div>
			<h1>Lista de Produtos Cadastrados</h1>
		</div>
		<div class="container2">
			<h2>Produtos</h2>
			<form name= "" action="">
			<div class="underline2"></div>
			<div>
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
						<%
						for (int i = 0; i < lista.size(); i++) {
						%>
						<tr>
							<td><%=lista.get(i).getId()%></td>
							<td><%=lista.get(i).getCodigo()%></td>
							<td><%=lista.get(i).getNome()%></td>
							<td><%=lista.get(i).getCategoria()%></td>
							<td><%=lista.get(i).getValor()%></td>
							<td><%=lista.get(i).getQuantidade()%></td>
							<td class="botProdutos">
								<a href="select?id=<%=lista.get(i).getId()%>">
									<input class="edProdutos" type="button" value="Editar" name="editar">	
								</a>
							</td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
				<div>
					<a href="create">
						<input type="button" value="Cadastrar Produto">
					</a>
				</div>
				<div>
					<a href="home">
						<input type="button" value="Sair">
					</a>					
				</div>
			</div>
			</form>
		</div>
	</main>
</body>
</html>