package data;

import java.text.DecimalFormat;

import util.Communicator;

public class User {
	private int id;
	private String name;
	private String password;
	private double points;

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
	
	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
	
	public void adjustPoints(double points)
	{
		setPoints(getPoints()+points);
		communicator.displayMessage("Current Points of " + name + " are " + df.format(getPoints()));
	}
}
