package games;

import java.util.List;
import java.util.Set;

import data.User;
import data.Word;
import util.Communicator;

public class SimpleGame extends Game {
	
	private User user = null;
	
	public SimpleGame(User user) {
		this.user = user;
	}

	@Override
	public void start() {
		start(0);
		
	}

	@Override
	public void start(int difficulty) {
		Word challenge = words.getWord(0);
		communicator.show(challenge);
		watch.start();
		String response = communicator.read();
		double time = watch.stop();
		boolean win = words.check(challenge, response);
		communicator.displayResult(win, time);
		user.adjustPoints(getPoints(win, challenge, time));
		
	}
	
}
