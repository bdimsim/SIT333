package sit333_week5;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.time.Instant;

public class WeatherController {
	public static final int HOURS_PER_DAY = 3;

	private static WeatherController instance;
	// https://docs.oracle.com/javase/8/docs/api/java/time/Clock.html
	// Best practice is to pass a Clock to any method that requires the current instant.
	// Used with with dependency injection
	private Clock clock;
	
	// Factory method for single instance WeatherController.
	public static WeatherController getInstance() {
		return instance == null ? new WeatherController() : instance;
	}
	
	// Initialise 10 hourly temperature
	private static double[] todaysHourlyTemperature = new double[HOURS_PER_DAY];
	
	// Private constructor prevents to create new instance manually.
	// A factory method needs to be used.
	private WeatherController() {
		System.out.println("Creating new weather controller.");
		
		// Initialise clock environment
		clock = Clock.systemDefaultZone();

		// sleep a while to simulate a delay
		sleep(2 + new Random().nextInt(5));
		
		// Insert 10 random temperature values in today's hourly list.
		Random random = new Random();
		for (int i=0; i<HOURS_PER_DAY; i++)
			todaysHourlyTemperature[i] = 1 + random.nextInt(30);

		System.out.println(Arrays.toString(todaysHourlyTemperature));
	}
	
	public void close() {
		System.out.println("Closing weather controller.");
		instance = null;
		
		// sleep a while to simulate a delay
		sleep(2 + new Random().nextInt(5));
	}
	
	public void setClock(Clock clock) {
		this.clock = clock;
	}

	// Calculate minimum of today's hourly temperatures.
	public double getTemperatureMinFromCache() {
		double minVal = 1000;
		for (int i=0; i<todaysHourlyTemperature.length; i++)
			if (minVal > todaysHourlyTemperature[i])
				minVal = todaysHourlyTemperature[i];

		return minVal;
	}

	// Calculate maximum of today's hourly temperatures.
	public double getTemperatureMaxFromCache() {
		double maxVal = -1;
		for (int i=0; i<todaysHourlyTemperature.length; i++)
			if (maxVal < todaysHourlyTemperature[i])
				maxVal = todaysHourlyTemperature[i];

		return maxVal;
	}
	
	// Calculate average of today's hourly temperatures.
	public double getTemperatureAverageFromCache() {
		double sumVal = 0;
		for (int i=0; i<todaysHourlyTemperature.length; i++)
			sumVal += todaysHourlyTemperature[i];

		return sumVal/todaysHourlyTemperature.length;
	}
	
	// Return temperature for given hour of current day.
	public double getTemperatureForHour(int hour) {
		// sleep a while to simulate a delay
		sleep(1 + new Random().nextInt(5));
		
		// Let's return a randomly selected temperature from hourly list if hour does not exist.
		if (hour > todaysHourlyTemperature.length)
			hour = 1 + new Random().nextInt(todaysHourlyTemperature.length);
		
		// Hour index starts from 0 instead of 1 due to array indexing.
		return todaysHourlyTemperature[hour-1];
	}
	
	// Persist reported temperature to data store and return recorded time. 
	public String persistTemperature(int hour, double temperature) {
		Instant instant = clock.instant();
		Date date = Date.from(instant);

		SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");
		String savedTime = sdf.format(date);

		System.out.println(
			"Temperature: " + temperature + " of hour: " + hour + ", saved at " + savedTime
		);

		// sleep a while to simulate a delay
		sleep(1 + new Random().nextInt(2));

		return savedTime;
	}
	
	// Calculated the number of hours temperature data is available for today.
	public int getTotalHours() {
		return todaysHourlyTemperature.length;
	}
	
	// Sleep for specified seconds.
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}