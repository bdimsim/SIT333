package sit333_week5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WeatherControllerTest {
	static WeatherController wController;
	static int nHours;
	static double[] hourlyTemps;

	@BeforeAll
	public static void setup() {
		System.out.println("+++ setup +++");

		// Initialise controller
		wController = WeatherController.getInstance();

		// Retrieve all the hours temperatures recorded as for today
		nHours = wController.getTotalHours();
		hourlyTemps = new double[nHours];
		for (int i = 0; i < nHours; i++) {
			hourlyTemps[i] = wController.getTemperatureForHour(i + 1);
		}
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

		double minTemperature = 1000;
		for (int i=0; i < nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = hourlyTemps[i];
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assertions.assertEquals(wController.getTemperatureMinFromCache(), minTemperature);	
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		// Retrieve all the hours temperatures recorded as for today
		double maxTemperature = -1;
		for (int i=0; i < nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = hourlyTemps[i]; 
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assertions.assertEquals(wController.getTemperatureMaxFromCache(), maxTemperature);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		// Retrieve all the hours temperatures recorded as for today
		double sumTemp = 0;
		for (int i=0; i < nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = hourlyTemps[i]; 
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / nHours;
		
		// Should be equal to the min value that is cached in the controller.
		Assertions.assertEquals(wController.getTemperatureAverageFromCache(), averageTemp);
	}
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
