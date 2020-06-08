package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.dao.EmpresaDAO;
import br.com.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class AlterarEmpresa
 */
@WebServlet("/alterarEmpresa")
public class AlterarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO dao = new EmpresaDAO();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Recebendo os parâmetros da web quando é GET fica visivel na url. */
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		String parametroId = request.getParameter("id");
		Long id = Long.valueOf(parametroId);

		// Formatando data do meu desejo
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date dataAbertura;
		// Convertendo para o formato data
		try {
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa(dataAbertura, nome);
		empresa.setId(id);

		dao.atualiza(empresa);

		request.setAttribute("empresa", empresa);
		response.sendRedirect("/gerenciador/listaEmpresas");
	}

}
