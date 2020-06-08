package br.com.gerenciador.repositorio;

import java.util.List;

import br.com.gerenciador.modelo.Empresa;

public interface EmpresaRepositorio {
	
	public void insere(final Empresa empresa);
	
	public List<Empresa> getListar();
	

}
