package zsir.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAOFactory implements AutoCloseable {
	
	
	private static final UserDAOFactory instance = new UserDAOFactory();
	private static EntityManager em = null;
	private static EntityManagerFactory emf = null;
	

	private UserDAOFactory() { }

	public static UserDAOFactory getInstance() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("dev");
		}
		if (em == null) {
			em = emf.createEntityManager();
		}
		return instance;
	}
	
	public UserDAO createDAO(){
		return new UserDAOImpl(em);
	}

	public void close() throws Exception {
		em.close();
		emf.close();
		
	}

}
