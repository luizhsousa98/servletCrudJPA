package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.dao.EmpresaDAO;
import br.com.gerenciador.modelo.Empresa;

@WebServlet("/removeEmpresa")
public class RemoveEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmpresaDAO dao = new EmpresaDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Long idEmpresa = Long.valueOf(paramId);

		dao.remove(idEmpresa);

		System.out.println(idEmpresa);
		
		response.sendRedirect("/listaEmpresas");


	}

}
