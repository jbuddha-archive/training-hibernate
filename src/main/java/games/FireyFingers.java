package games;

import data.User;
import data.Word;
import util.Stopwatch;

public class FireyFingers extends Game {
	int seconds;
	User user;
	
	public FireyFingers(User user, int time) {
		this.user = user;
		this.seconds = time;
	}
	
	@Override
	public void start() {
		start(0);
	}

	@Override
	public void start(int difficulty) {
		Stopwatch globalTimer = new Stopwatch();
		int limit = this.seconds;
		double points = 0;
		globalTimer.start();
		while(true)
		{
			Word challenge;
			
			if(difficulty == 0)
				challenge = words.getWord();
			else
				challenge = words.getWord(difficulty);
			
			communicator.show(challenge);
			watch.start();
			String response = communicator.read();
			if(globalTimer.elapsed() > limit)
			{
				communicator.displayMessage("Sorry, timed out");
				break;
			}			
			double time = watch.stop();
			boolean win = words.check(challenge, response);
			communicator.displayResult(win, time);
			points += getPoints(win, challenge, time);
		}
		user.adjustPoints(points);
	}
}
