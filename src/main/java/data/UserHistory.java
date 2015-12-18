package data;

import java.util.Date;

/**
 *
 * @author buddha
 */
public class UserHistory {
	private Date time;
	private double points;

	public UserHistory(Date time, double points) {
		this.time = time;
		this.points = points;
	}

	public UserHistory() {
		
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
	
	
}
