package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BancoDados;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/home", "/create", "/insert", "/read", "/delete", "/select", "/update" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans produto = new JavaBeans();
	//BancoDados bd = new BancoDados();

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

		}
		else if (action.equals("/create")) {
			response.sendRedirect("cadastro.html");

		}
		else if (action.equals("/insert")) {
			adicionarProduto(request, response);
		}
		else if (action.equals("/read")) {
			exibirProdutos(request, response);
		}
		else if (action.equals("/delete")) { 
			excluirProduto(request, response);
		}
		else if (action.equals("/select")) { 
			listarProduto(request, response);
		}
		else if (action.equals("/update")) { 
			atualizarProduto(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */
	protected void adicionarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		produto.setNome(request.getParameter("nome"));
		produto.setValor(request.getParameter("valor"));
		produto.setCodigo(request.getParameter("codigo"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setQuantidade(request.getParameter("quantidade"));

		dao.inserirProduto(produto);

		response.sendRedirect("read");
	}
	protected void exibirProdutos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> lista = dao.listarProdutos();

		request.setAttribute("produtos", lista);
		RequestDispatcher rdp = request.getRequestDispatcher("produtos.jsp");
		rdp.forward(request, response);
	}
	protected void excluirProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		produto.setId(id);
		dao.deletarProduto(produto);
		
		response.sendRedirect("read");
	}
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		produto.setId(id);
		dao.selecionarProduto(produto);

		request.setAttribute("id", produto.getId());
		request.setAttribute("codigo", produto.getCodigo());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("categoria", produto.getCategoria());
		request.setAttribute("valor", produto.getValor());
		request.setAttribute("quantidade", produto.getQuantidade());

		RequestDispatcher rdp = request.getRequestDispatcher("editarProduto.jsp");
		rdp.forward(request, response);
	}
	protected void atualizarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		produto.setId(request.getParameter("id"));
		produto.setNome(request.getParameter("nome"));
		produto.setValor(request.getParameter("valor"));
		produto.setCodigo(request.getParameter("codigo"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setQuantidade(request.getParameter("quantidade"));

		dao.editarProduto(produto);

		response.sendRedirect("read");
	}
}
