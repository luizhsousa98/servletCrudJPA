package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.dao.EmpresaDAO;
import br.com.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class MostraEmpresa
 */
@WebServlet("/editaEmpresa")
public class MostraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO dao = new EmpresaDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroId = request.getParameter("id");
		Long id = Long.valueOf(parametroId);
		
		Empresa emp = dao.getFindById(id);
		
		request.setAttribute("empresa", emp);
		
		RequestDispatcher rq = request.getRequestDispatcher("/webapp/formularios/EditarEmpresa.jsp");
		rq.forward(request, response);
	}

}
