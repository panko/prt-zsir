package zsir.model;

public class UserManager {
	
	private UserDAO ud;
	
	public User getUserFromDB(String name){
		return ud.getUser(name);
	}

}
