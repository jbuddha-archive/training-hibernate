package data;

import java.util.Date;
import java.util.Random;

public final class Word {
	private String word;
	
	private static final Random random = new Random(new Date().getTime());
	
	public Word(String word) {
		super();
		this.setWord(word);
	}

	@Override
	public String toString() {
		return word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public String scramble()
	{
		char[] charArray = word.toCharArray();
		int len = word.length();
		for(int i = 0; i < len; i++)
		{
			int r = random.nextInt(len);
			char c = charArray[r];
			charArray[r] = charArray[i];
			charArray[i] = c;
		}
		return new String(charArray);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.trim().equalsIgnoreCase(other.word.trim()))
			return false;
		return true;
	}
	
	
	
}
