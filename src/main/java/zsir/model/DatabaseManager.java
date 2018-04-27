package zsir.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {

	private static final DatabaseManager instance = new DatabaseManager();
	private static EntityManager em = null;
	private static EntityManagerFactory emf = null;
	

	private DatabaseManager() { }

	public static DatabaseManager getInstance() {
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
	
	
	public static void disconnect(){
		em.close();
		emf.close();
	} 
}
