package zsir.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class UserDAOImpl implements UserDAO {
	
	private EntityManager em;
	
	/**
	 *Set EntityManager.
	 *@param em EntityManager.
	 */
	public UserDAOImpl(EntityManager em) {
		this.em = em;
	}


	public void createUser(String name, String pass) {
		em.getTransaction().begin();
		User user = new User(name, pass);
		em.persist(user);
		em.getTransaction().commit();

	}


	public List<User> getUser(String name) {
		TypedQuery<User> q = em.createQuery("SELECT u FROM ZSIRUSER u WHERE u.userName='"
                + name + "'",User.class);

		return q.getResultList();
	}


}


