package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class WordsDB {
	
	int maxlen = 0;
	public int getMaxlen() {
		return maxlen;
	}

	private HashMap<Integer, List<Word>> words = new HashMap<>();
	private static final Random random = new Random(new Date().getTime());
	
	public WordsDB()  {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("words.txt")))){
			String word = "";
			while((word = reader.readLine()) != null)
			{
				if(word.length() > maxlen)
					maxlen = word.length();
				
				if(words.containsKey(word.length()))
				{
					words.get(word.length()).add(new Word(word));
				}
				else{
					words.put(word.length(), new ArrayList<>() );
					words.get(word.length()).add(new Word(word));
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		
	}
	
	public boolean check(Word challenge, String response)
	{
		return check(challenge, new Word(response));
	}
	
	public boolean check(Word challenge, Word response)
	{
		return challenge.equals(response);
	}
	
	public Word getWord() 
	{
		return getWord(random.nextInt(maxlen));
	}
	
	public Word getWord(int difficulty)
	{
		if(difficulty == 0)
			difficulty = random.nextInt(maxlen);
		
		List<Word> list = words.get(difficulty);
		return list.get(random.nextInt(list.size()));
	}
}
