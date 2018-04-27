package zsir.model;

import javax.persistence.EntityManager;

public class UserDAOImpl implements UserDAO {
	
	private EntityManager em;
	
	/**
	 *Set EntityManager.
	 *@param em EntityManager.
	 */
	public UserDAOImpl(EntityManager em) {
		this.em = em;
	}


	public void createUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

	}

	public User getUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
