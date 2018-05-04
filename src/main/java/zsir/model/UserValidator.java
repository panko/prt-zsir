package zsir.model;

import java.util.List;



public class UserValidator {
	
	private UserDAO ud;

    public UserValidator(UserDAO ud) {
        this.ud = ud;
    }
  
    public boolean loginValidate(String username, String password) {
        
        List<User> userLista = ud.getUser(username);
        
        return userLista.size()>0 && userLista.get(0).getPassword().equals(password);
        
    }
    
    public boolean regValidate(String username) {
        List<User> userLista = ud.getUser(username);
        
        return userLista.isEmpty() && !username.isEmpty();
    }
	
}
