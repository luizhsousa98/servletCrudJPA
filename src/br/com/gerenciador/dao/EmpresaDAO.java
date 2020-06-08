package br.com.gerenciador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.gerenciador.conexao.JPAUtil;
import br.com.gerenciador.modelo.Empresa;
import br.com.gerenciador.repositorio.Crud;
import br.com.gerenciador.repositorio.EmpresaRepositorio;

public class EmpresaDAO implements EmpresaRepositorio, Crud {

	@PersistenceContext
	protected EntityManager em = new JPAUtil().getEntityManager();

	/**
	 * @author lhsousa: Insere o nome da empresa
	 */
	@Override
	public void insere(Empresa empresa) {

		try {
			em.getTransaction().begin();

			em.persist(empresa);

			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	/**
	 * @author lhsousa: Lista todas as empresas cadastradas.
	 */
	@Override
	public List<Empresa> getListar() {

		TypedQuery<Empresa> query = em.createQuery("select e from Empresa e", Empresa.class);

		return query.getResultList();
	}

	@Override
	public void remove(final Long id) {

		try {
			Empresa emp = getFindById(id);
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	/**
	 * @author lhsousa: realizando update.
	 */
	@Override
	public void atualiza(Empresa empresa) {

		try {
			em.getTransaction().begin();

			em.merge(empresa);

			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	/**
	 * @author lhsousa: Realiza select por id
	 */
	@Override
	public Empresa getFindById(Long id) {
		return em.find(Empresa.class, id);
	}

}
