package zsir.model;

public interface UserDAO {
	public void createUser(User user);
	public User getUser(String name);
}
