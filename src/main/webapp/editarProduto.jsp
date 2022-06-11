<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar - Produto</title>
<link rel="stylesheet" href="style.css">
<script src="scripts/validador.js"></script>
</head>
<body>
	<main>
		<h1>Editar Produto</h1>
		<div class="container2">
			<form name="frmCadastro" action="update">
			<div class="input-geral">
			
					<h3>ID:</h3>
					<input type="text" name="id" readonly value="<%out.print(request.getAttribute("id"));%>"
						required>
					
					<h3>Código de barras:</h3>
					<h6 class = "asterisco">*</h6>
					<input type="text" name="codigo" value="<%out.print(request.getAttribute("codigo"));%>"
						required>
					<div class="underline"></div>

					<h3>Nome:</h3>
					<h6 class = "asterisco">*</h6>
					<input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>" required>
					<div class="underline"></div>

					<h3>Categoria:</h3>
					<input type="text" name="categoria" value="<%out.print(request.getAttribute("categoria"));%>">
					<div class="underline"></div>

					<h3>Valor:</h3>
					<h6 class = "asterisco">*</h6>
					<input type="text" name="valor" value="<%out.print(request.getAttribute("valor"));%>" required>
					<div class="underline"></div>

					<h3>Quantidade:</h3>
					<h6 class = "asterisco">*</h6>
					<input type="text" name="quantidade" value="<%out.print(request.getAttribute("quantidade"));%>" required>
					<div class="underline"></div>
				</div>
				
				<div>
					<input type="button" value="Salvar" onclick="validar()">
				</div>
				<div>
					<a href="home">
						<input type="button" value="Sair">
					</a>					
				</div>
			</form>
		</div>
	</main>
</body>
</html>