package games;

import data.Word;
import data.WordsDB;
import util.Communicator;
import util.Stopwatch;

public abstract class Game {
	
	protected WordsDB words = new WordsDB();
	protected Stopwatch watch = new Stopwatch();
	protected Communicator communicator = Communicator.getInstance();
	
	protected double STANDARD_LENGTH = 6;
	protected double STANDARD_TIME = 5;
	
	public abstract void start();
	
	public abstract void start(int difficulty);
	
	public double getPoints(boolean win, Word word, double seconds) {
		int len = word.getWord().length();
		double points ;
		if(win){
			points = len * STANDARD_TIME / (STANDARD_LENGTH * seconds); 
		}
		else {
			points = -STANDARD_LENGTH / len; 
		}
		
		return points;
	}
}
