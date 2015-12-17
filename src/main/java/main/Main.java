package main;

import data.User;
import games.FireyFingers;
import games.Game;
import java.io.IOException;
import util.Communicator;
import static util.Communicator.getInstance;
import util.OrmUtilities;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Communicator communicator = getInstance();
		
		OrmUtilities.getSession();
		try  {
			String cont = null;
			
			String name = communicator.read("Enter your name: ");
			User u = User.findUser(name);
			Game game = new FireyFingers(u, 10);
			
			do{
				game.start(4);
				cont = communicator.read("Do you want to continue(yes/no): ");
			} while(cont.startsWith("y"));
			
			communicator.displayMessage("Points for User are " + u.getGameData().getPoints());
		} finally{
			communicator.close();
			OrmUtilities.closeSession();
			System.exit(0);
		}
	}
}
