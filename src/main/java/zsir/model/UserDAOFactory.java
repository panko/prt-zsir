package zsir.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * A factory for creating UserDAO objects.
 */
public class UserDAOFactory implements AutoCloseable {
	
	
	/** The Constant instance. */
	private static final UserDAOFactory instance = new UserDAOFactory();
	
	/** The Entity manager. */
	private static EntityManager em = null;
	
	/** The Entity manager factory. */
	private static EntityManagerFactory emf = null;
	

	/**
	 * Instantiates a new user DAO factory.
	 */
	private UserDAOFactory() { }

	/**
	 * Gets the single instance of UserDAOFactory.
	 *
	 * @return single instance of UserDAOFactory
	 */
	public static UserDAOFactory getInstance() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("my-little-database");
		}
		if (em == null) {
			em = emf.createEntityManager();
			//em.createNativeQuery("CREATE SEQUENCE ID_SEQ");
		}
		return instance;
	}
	
	/**
	 * Creates a new UserDAO object.
	 *
	 * @return the user DAO
	 */
	public UserDAO createDAO(){
		return new UserDAOImpl(em);
	}

	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	public void close() throws Exception {
		em.close();
		emf.close();
		
	}

}
