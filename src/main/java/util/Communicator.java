package util;

import java.util.Scanner;

import data.Word;

public class Communicator {
	
	private static Communicator instance = null;
	private static Scanner scanner = null;
	
	static{
		if(instance == null)
		{
			instance = new Communicator();
			scanner = new Scanner(System.in);
		}
	}
	
	private Communicator()
	{
		
	}
	
	public static Communicator getInstance()
	{
		return instance;
	}
	
	public void show(Word word)
	{
		System.out.println("Solve this["+word+"]: " + word.scramble());
	}
	
	public String read()
	{
		return scanner.nextLine();
	}
	
	public void displayResult(boolean win, double seconds)
	{
		if(win)
			System.out.println("Hurray You solved it in " + seconds);
		else
			System.out.println("Sorry, you lost");
	}
	
	public void displayMessage(String message)
	{
		System.out.println(message);
	}
	
		public String read(String message)
	{
		System.out.print(message);
		return read();
	}
	
	public void close()
	{
		scanner.close();
	}
}
