function validar() {
	let codigo = frmCadastro.codigo.value;
	let nome = frmCadastro.nome.value;
	let valor = frmCadastro.valor.value;
	let quantidade = frmCadastro.quantidade.value;

	if (codigo === "") {
		alert('Preencha o campo Código de barras!')
		frmCadastro.codigo.focus()
		return false
	} else if (nome === "") {
		alert('Preencha o campo Nome!')
		frmCadastro.nome.focus()
		return false
	} else if (valor === "") {
		alert('Preencha o campo Valor!')
		frmCadastro.valor.focus()
		return false
	} else if (quantidade === "") {
		alert('Preencha o campo Quantidade!')
		frmCadastro.quantidade.focus()
		return false
	} else {
		document.forms["frmCadastro"].submit()
	}
}
function validarPd() {
	let nome = frmPesquisa.nome.value;

	if (nome === "") {
		alert('Preencha o campo nome para pesquisa!')
		frmCadastro.codigo.focus()
		return false
	}
	else {
		document.forms["frmPesquisa"].submit()
	}
}











