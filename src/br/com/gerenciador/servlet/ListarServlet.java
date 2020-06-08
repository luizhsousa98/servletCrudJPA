package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.dao.EmpresaDAO;
import br.com.gerenciador.modelo.Empresa;

@WebServlet("/listaEmpresas")
public class ListarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// Acessando Dao
	private EmpresaDAO dao = new EmpresaDAO();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Empresa> emp = dao.getListar();

		RequestDispatcher rd = request.getRequestDispatcher("/webapp/ListaEmpresa.jsp");

		rd.forward(request, response);
	}

}
