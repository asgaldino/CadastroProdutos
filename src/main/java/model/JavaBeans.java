package model;

public class JavaBeans {
	private String id;
	private String nome;
	private String valor;
	private String codigo;	
	private String categoria;	
	private String quantidade;
	
	//constructor from super class
	public JavaBeans() {
		super();
	}
	//constructor using fields
	public JavaBeans(String id, String codigo, String nome, String categoria, String valor, String quantidade) {
		super();
		this.id = id;		
		this.nome = nome;
		this.valor = valor;
		this.codigo = codigo;
		this.categoria = categoria;
		this.quantidade = quantidade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
}