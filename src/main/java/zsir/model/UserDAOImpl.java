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


	/* (non-Javadoc)
	 * @see zsir.model.UserDAO#createUser(java.lang.String, java.lang.String)
	 */
	public void createUser(String name, String pass) {
		em.getTransaction().begin();
		User user = new User(name, pass);
		em.persist(user);
		em.getTransaction().commit();

	}


	/* (non-Javadoc)
	 * @see zsir.model.UserDAO#getUser(java.lang.String)
	 */
	public List<User> getUser(String name) {
		TypedQuery<User> q = em.createQuery("SELECT u FROM ZSIRUSER u WHERE u.userName='"
                + name + "'",User.class);

		return q.getResultList();
	}


}


