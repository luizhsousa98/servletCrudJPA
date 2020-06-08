package br.com.gerenciador.repositorio;

import br.com.gerenciador.modelo.Empresa;

public interface Crud {

	public void remove(final Long id);

	public void atualiza(final Empresa empresa);

	// Busca a empresa pelo n�mero do id
	public Empresa getFindById(final Long id);

}
