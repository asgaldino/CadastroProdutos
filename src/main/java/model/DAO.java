package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://127.0.0.1:3306/projeto1?useTimezone=true&serverTimezone=UTC";

	private String user = "root";

	private String password = "senhadobanco1";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado");
			return con;
		} catch (Exception e) {
			System.out.println("Não conectado");
			System.out.println(e);
			return null;
		}
	}

	public void inserirProduto(JavaBeans produto) {
		String insert = "INSERT INTO Produto (codigo, nome, categoria, valor, quantidade)  values (?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insert);

			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getValor());
			pst.setString(5, produto.getQuantidade());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("Operação não executada");
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeans> listarProdutos() {
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String select = "SELECT * FROM Produto order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			ResultSet rst = pst.executeQuery();

			while (rst.next()) {
				String id = rst.getString(1);
				String codigo = rst.getString(2);
				String nome = rst.getString(3);
				String categoria = rst.getString(4);
				String valor = rst.getString(5);
				String quantidade = rst.getString(6);

				produtos.add(new JavaBeans(id, codigo, nome, categoria, valor, quantidade));
			}
			con.close();
			return produtos;
			
		} catch (Exception e) {
			System.out.println("Operação não executada");
			System.out.println(e);
			return null;
		}
	}
	public void deletarProduto(JavaBeans produto) {
		String delete = "DELETE FROM Produto where id = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getId());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("Operação não executada");
			System.out.println(e);
		}
	}
	public void selecionarProduto(JavaBeans produto) {
		String selectP = "SELECT * FROM Produto where id = ?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(selectP);
			pst.setString(1, produto.getId());
			ResultSet rst = pst.executeQuery();
			
			while (rst.next()) {
				produto.setId(rst.getString(1));
				produto.setCodigo(rst.getString(2));
				produto.setNome(rst.getString(3));
				produto.setCategoria(rst.getString(4));
				produto.setValor(rst.getString(5));
				produto.setQuantidade(rst.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("Operação não executada");
			System.out.println(e);
		}
	}
	public void editarProduto(JavaBeans produto) {
		String update = "UPDATE Produto set codigo=?, nome=?, categoria=?, valor=?, quantidade=? where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getValor());
			pst.setString(5, produto.getQuantidade());
			pst.setString(6, produto.getId());
			
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("Operação não executada");
			System.out.println(e);
		}
	}
	public ArrayList<JavaBeans> buscarProdutoNome(HttpServletRequest request) {
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String nomeLk = (request.getParameter("nome"));
		String select = "SELECT * FROM Produto where nome like '%"+nomeLk+"%'order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			ResultSet rst = pst.executeQuery();

			while (rst.next()) {
				String id = rst.getString(1);
				String codigo = rst.getString(2);
				String nome = rst.getString(3);
				String categoria = rst.getString(4);
				String valor = rst.getString(5);
				String quantidade = rst.getString(6);

				produtos.add(new JavaBeans(id, codigo, nome, categoria, valor, quantidade));
			}
			con.close();
			return produtos;
			
		} catch (Exception e) {
			System.out.println("Operação não executada");
			System.out.println(e);
			return null;
		}
	}
}
