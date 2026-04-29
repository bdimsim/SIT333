package sit333_week5;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WeatherControllerTest {
	private static WeatherController wController;
	private static Clock fakeClock;
	private static int nHours;
	private static double[] hourlyTemps;
	private static double minTemperature;
	private static double maxTemperature;
	private static double avgTemperature;

	@BeforeAll
	public static void setup() {
		System.out.println("+++ setup +++");

		minTemperature = 1000;
		maxTemperature = -1;
		double sumTemperature = 0;

		// Initialise controller
		wController = WeatherController.getInstance();

		// Retrieve all the hours temperatures recorded as for today
		nHours = wController.getTotalHours();
		hourlyTemps = new double[nHours];

		// Hour range: 1 to nHours
		for (int i = 0; i < nHours; i++) {
			hourlyTemps[i] = wController.getTemperatureForHour(i + 1);

			double temperatureVal = hourlyTemps[i];
			if (minTemperature > temperatureVal) minTemperature = temperatureVal;
			if (maxTemperature < temperatureVal) maxTemperature = temperatureVal;
			sumTemperature += temperatureVal;
		}
		avgTemperature = sumTemperature / nHours;

		// "Z" means exactly the time as prescribed, regardless of local time
		// "T" is the separator between date and time
		// "YYYY-MM-DD" date format
		Instant fakeInstant = Instant.parse("2026-04-29T10:00:00Z");
		// Interpret time using system's default time zone
		fakeClock = Clock.fixed(fakeInstant, Clock.systemDefaultZone().getZone());
		wController.setClock(fakeClock); // Inject fake clock to controller
	}

	@AfterAll
	public static void cleanup() {
		System.out.println("+++ cleanup +++");

		// Shutdown controller
		wController.close();
	}

	@Test
	public void testStudentIdentity() {
		String studentId = "220250896";
		Assertions.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Brandon Dimoski";
		Assertions.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		
		// Should be equal to the min value that is cached in the controller.
		Assertions.assertEquals(wController.getTemperatureMinFromCache(), minTemperature);	
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

		// Should be equal to the min value that is cached in the controller.
		Assertions.assertEquals(wController.getTemperatureMaxFromCache(), maxTemperature);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

		// Should be equal to the min value that is cached in the controller.
		Assertions.assertEquals(wController.getTemperatureAverageFromCache(), avgTemperature);
	}

	@Test
	public void testTemperaturePersist() {
		System.out.println("+++ testTemperaturePersist +++");
		
		Instant instant = fakeClock.instant();
		Date date = Date.from(instant);
		SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");
		String now = sdf.format(date);

		int hour = instant.atZone(fakeClock.getZone()).getHour();
		System.out.println("Hour: " + hour);

		String persistTime = wController.persistTemperature(hour, 19.5);
		
		System.out.println("Persist time: " + persistTime + ", now: " + now);
		
		Assertions.assertEquals(persistTime, now);
	}
}