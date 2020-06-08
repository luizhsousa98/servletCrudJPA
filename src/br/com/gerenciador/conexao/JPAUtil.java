package br.com.gerenciador.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 * 
 * @author lhsousa
 * Conexão de acesso ao persistence xml
 */
public class JPAUtil {
	
	@PersistenceUnit
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gerenciador");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
