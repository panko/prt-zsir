package zsir.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



/**
 * The Class UserDAOImpl.
 */
public class UserDAOImpl implements UserDAO {
	
	/** The Entity manager. */
	private EntityManager em;
	
	/**
	 *Set EntityManager.
	 *@param em EntityManager.
	 */
	public UserDAOImpl(EntityManager em) {
		this.em = em;
	}


  /**
   * Creates the user.
   *
   * @param name the name
   * @param pass the password
   */
	public void createUser(String name, String pass) {
		em.getTransaction().begin();
		User user = new User(name, pass);
		em.persist(user);
		em.getTransaction().commit();

	}


  /**
   * Gets the user.
   *
   * @param name the name
   * @return the list of users
   */
	public List<User> getUser(String name) {
		TypedQuery<User> q = em.createQuery("SELECT u FROM ZSIRUSER u WHERE u.userName='"
                + name + "'",User.class);

		return q.getResultList();
	}


}


