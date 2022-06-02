package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BancoDados;
//import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/home", "/create", "/insert", "/read", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//DAO dao = new DAO();
	JavaBeans produto = new JavaBeans();
	BancoDados bd = new BancoDados();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/home")) {
			response.sendRedirect("index.html");
			
		} else if (action.equals("/create")) {
			response.sendRedirect("cadastro.html");
			
		}else if (action.equals("/insert")) {
			adicionarProduto(request, response);
			
		}
		/*
		else if (action.equals("/read")) {
			listarAlunos(request, response);
		}
		else if (action.equals("/delete")) {
			//remova o registro do banco de dados
			removerAlunos(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	*/
	protected void adicionarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Nome:" + request.getParameter("nome") );
		produto.setNome(request.getParameter("nome"));
		produto.setValor(request.getParameter("valor"));
		produto.setCodigo(request.getParameter("codigo"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setQuantidade(request.getParameter("quantidade"));
		
		String insertQuery = bd.cadastrarProduto(produto);
        System.out.println(insertQuery);
        bd.inserirAlterarExcluir(insertQuery);
		
		response.sendRedirect("read");
	}

}
