import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.agiletickets.models.Estabelecimento;
import br.com.caelum.agiletickets.persistencia.JPAEstabelecimentoDao;

public	class	JPAEstabelecimentoDaoTest	{
		
		private	static	EntityManagerFactory	emf;
		private	EntityManager	manager;
		private	JPAEstabelecimentoDao	dao;	
	
	@BeforeClass
	public	static	void	beforeClass()	{
					emf	=	Persistence.createEntityManagerFactory("tests");
	}

	@Before
	public	void	before()	{
					this.manager	=	emf.createEntityManager();
					this.manager.getTransaction().begin();
					this.dao	=	new	JPAEstabelecimentoDao(manager);
	}

	@After
	public	void	after()	{
					this.manager.getTransaction().rollback();
					this.manager.close();
	}

	@AfterClass
	public	static	void	afterClass()	{
					emf.close();
	}
	
	@Test
	public	void	deveAdicionarUmEstabelecimento()	{
					Estabelecimento	novo	=	new	Estabelecimento();
					novo.setNome("Novo	Estabelecimento	de	Testes");
					novo.setEndereco("Endereco	do	Estabelecimento	de	Teste");
					novo.setTemEstacionamento(true);
					dao.adiciona(novo);
					Estabelecimento	adicionado	=	manager.find(
													Estabelecimento.class,	novo.getId());
					Assert.assertEquals(adicionado,	novo);
	}

}