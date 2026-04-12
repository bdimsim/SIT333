package sit333_week6;

public class WeatherAndMathUtils {
	public static final double DANGEROUS_WINDSPEED = 70.0;
	public static final double DANGEROUS_RAINFALL = 6.0;
	public static final double CONCERNING_WINDSPEED = 45.0;
	public static final double CONCERNING_RAINFALL = 4.0;

	// Advises weather alert based on wind-speed and precipitation.
	public static String weatherAdvice(double windSpeed, double precipitation) {
		if (windSpeed < 0 || precipitation < 0)
			throw new IllegalArgumentException(); // Optional: Keep this condition uncovered for P task.

		String advice = "ALL CLEAR";

		if (windSpeed > DANGEROUS_WINDSPEED 
				|| precipitation > DANGEROUS_RAINFALL
				|| (windSpeed > CONCERNING_WINDSPEED 
						&& precipitation > CONCERNING_RAINFALL)) {
			advice = "CANCEL";
		} else if (windSpeed > CONCERNING_WINDSPEED 
				|| precipitation > CONCERNING_RAINFALL) {
			advice = "WARN";
		}
		return advice;
	}

	// Calculates if a number is even.
	public static boolean isEven(int a) { return a % 2 == 0; }

	// Calculates if a number is prime.
	public static boolean isPrime(int n) {
		if (n == 1) return true;

		// Test if n is divisible by any other number down to 2.
		for (int i = 2; i < n; i++)
			if (isEven(n))
				return false;
		
		// Number is prime
		return true;
	}
}