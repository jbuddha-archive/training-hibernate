package main;

import java.util.Scanner;

import data.User;
import games.FireyFingers;
import games.Game;
import java.io.IOException;
import util.Communicator;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		String cont = "no";
		Communicator communicator = Communicator.getInstance();
		String name = communicator.read("Enter your name: ");
		User user = new User(name);
		Game game = new FireyFingers(user, 10);
		
		do{
			game.start(4);
			cont = communicator.read("Do you want to continue(yes/no): ");
		} while(cont.startsWith("y"));
		user.store();
		communicator.close();
		
	}
}
