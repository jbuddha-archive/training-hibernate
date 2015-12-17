package data;

import java.text.DecimalFormat;
import java.util.List;
import org.hibernate.Session;

import util.Communicator;
import util.OrmUtilities;

public class User {

	private int id;
	private String name;
	private String password;

	private GameData gameData = new GameData();

	static Communicator communicator = Communicator.getInstance();

	DecimalFormat df = new DecimalFormat("#.##");

	public User()
	{
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GameData getGameData() {
		return gameData;
	}

	public void setGameData(GameData gameData) {
		this.gameData = gameData;
	}
	
	public void adjustPoints(double points)
	{
		getGameData().setPoints(getGameData().getPoints()+points);
		communicator.displayMessage("Current Points of " + name + " are " + df.format(getGameData().getPoints()));
	}
	
	public static User findUser(String name)
	{
		Session session = OrmUtilities.getSession();
		List list = session.createQuery("FROM data.User where name='" + name + "'").list();
		if(list.size() == 1)
		{
			User user = (User)list.get(0);
			if(communicator.read("Enter your password: ").contentEquals(user.getPassword()))
				return user;

			communicator.displayMessage("Incorrect Password");
			throw new RuntimeException("Incorrect Password");
		}
		else
		{
			User user = new User();
			user.setName(name);
			user.setPassword(communicator.read("Enter a password: "));
			session.save(user);
			return user;
		}
	}
}
