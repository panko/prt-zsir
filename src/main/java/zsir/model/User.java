package zsir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class User.
 */
@Entity(name = "ZSIRUSER")
@Table(name = "ZSIRUSER")
public class User {
	
	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private int id;
	
	/** The user name. */
	@Column(name = "USERNAME")
	private String userName;
	
	/** The password. */
	@Column(name = "PASSWORD")
	private String password;
	
	/** The score. */
	@Column(name = "SCORE")
	private int score;
	
	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}
	
	
	/**
	 * Instantiates a new user.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
