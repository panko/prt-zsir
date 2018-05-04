package zsir.model;

import java.util.List;

public interface UserDAO {
	public void createUser(String name, String pass);
	public List<User> getUser(String name);
}
