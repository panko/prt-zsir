package zsir.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "USER")
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "DATE_OF_REG")
	private Date date;
	
	@Column(name = "SCORE")
	private int score;
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.score = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}



}
