package zsir.model;

import java.util.List;



// TODO: Auto-generated Javadoc
/**
 * The User Validator Class .
 */
public class UserValidator {
	
	/** The ud. */
	private UserDAO ud;

    /**
     * Instantiates a new user validator.
     *
     * @param ud the ud
     */
    public UserValidator(UserDAO ud) {
        this.ud = ud;
    }
  
    /**
     * Login validate.
     * Returns true if we have the user, and the paswords are matching.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    public boolean loginValidate(String username, String password) {
        
        List<User> userLista = ud.getUser(username);
        
        return userLista.size()>0 && userLista.get(0).getPassword().equals(password);
        
    }
    
    /**
     * Registartion validatator. 
     * We can register our new user if dont have one with this name.
     * The username can not be empty.
     *
     * @param username the user's name
     * @return true, if successful
     */
    public boolean regValidate(String username) {
        List<User> userLista = ud.getUser(username);
        
        return userLista.isEmpty() && !username.isEmpty();
    }
	
}
