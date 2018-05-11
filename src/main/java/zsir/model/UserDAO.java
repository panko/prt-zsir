package zsir.model;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 */
public interface UserDAO {
	
	/**
	 * Creates the user.
	 *
	 * @param name the name
	 * @param pass the pass
	 */
	public void createUser(String name, String pass);
	
	/**
	 * Gets the user.
	 *
	 * @param name the name
	 * @return the user
	 */
	public List<User> getUser(String name);
}
