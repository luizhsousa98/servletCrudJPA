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

@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// Acessando Dao
	private EmpresaDAO dao = new EmpresaDAO();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Recebendo os parâmetros da web quando é GET fica visivel na url. */
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");

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

		dao.insere(empresa);

		// Atributo que vai no jsp
		request.setAttribute("empresa", empresa.getNome());

		/* Fazendo redirecionamento, não duplica informações ao redirecionar página */
		response.sendRedirect("listaEmpresas");

		// Caminho que a minha página irá
//		RequestDispatcher rd = request.getRequestDispatcher("/webapp/NovaEmpresaCriada.jsp");

//		rd.forward(request, response);

	}

}
