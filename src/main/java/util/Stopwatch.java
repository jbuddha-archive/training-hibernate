package util;

import java.time.Duration;
import java.time.Instant;

public class Stopwatch {
	
	private Instant i;
	private boolean running = false;
	
	public void start()
	{
		i = Instant.now();
		running = true;
	}
	
	public double stop()
	{
		if(running == true)
		{	
			double time = elapsed();
			running = false;
			return time;
		}
		throw new RuntimeException("Stopwatch not running");
	}
	
	public double elapsed()
	{
		if(running == true)
			return Duration.between(i, Instant.now()).toMillis() * 1.0 / 1000;
		else
			return 0;
	}
}
