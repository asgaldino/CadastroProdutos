package model;

import java.sql.*;

public class BancoDados {
	// Endereço para conexão ao BD
    String urlBD = "jdbc:mysql://localhost:3306/projeto1?user=root&password=senhadobanco1";

    // Driver utilizado para acesso ao BD
    String driver = "com.mysql.cj.jdbc.Driver";

    // Conexão ao BD
    
	
	public Connection conexao;

	public String conectar(String URL, String Driver) {
		
		try {
			Class.forName(Driver);
			conexao = (Connection) DriverManager.getConnection(URL);
			return "Conectado";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "Não foi Possível Conectar ";
		}
	}

	public int inserirAlterarExcluir(String query) {
		System.out.println(conectar(urlBD, driver));
		int linhas = 0;
		try {
			Statement st = conexao.createStatement();
			linhas = st.executeUpdate(query);
			System.out.println("Operação Efetudada com Sucesso");
			return linhas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Operação Não Efetuada");
		}
		return linhas;
	}

	public ResultSet consultar(String query) {
		Statement st;
		ResultSet resultado = null;
		try {
			st = conexao.createStatement();
			resultado = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public String cadastrarProduto(JavaBeans produto) {			
			
			String codigo = produto.getCodigo();
			String nome = produto.getNome();
			String categoria = produto.getCategoria();
			String valor = produto.getValor();
			String quantidade = produto.getQuantidade();

		return ("INSERT INTO Produto values (NULL, '"+codigo+"', '"+nome+"', '"+categoria+"', '"+valor+"', '"+quantidade+"')");
	}
}
