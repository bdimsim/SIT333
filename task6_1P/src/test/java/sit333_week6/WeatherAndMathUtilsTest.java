package sit333_week6;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherAndMathUtilsTest {
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
	public void testFalseNumberIsEven() {
		int odd = 11;
		Assertions.assertFalse(WeatherAndMathUtils.isEven(odd));
	}

	@Test
	public void testTrueNumberIsEven() {
		int even = 10;
		Assertions.assertTrue(WeatherAndMathUtils.isEven(even));
	}

	@Test
	public void testTrueNumberIsPrimeOne() {
		int prime = 1;
		Assertions.assertTrue(WeatherAndMathUtils.isPrime(prime));
	}

	@Test
	public void testTrueNumberIsPrimeTwo() {
		int prime = 2;
		Assertions.assertTrue(WeatherAndMathUtils.isPrime(prime));
	}

	@Test
	public void testTrueNumberIsPrimeOdd() {
		int prime = 3;
		Assertions.assertTrue(WeatherAndMathUtils.isPrime(prime));
	}

	@Test
	public void testFalseNumberIsPrimeEven() {
		int prime = 4;
		Assertions.assertFalse(WeatherAndMathUtils.isPrime(prime));
	}

    @Test
    public void testCancelWeatherAdviceWindSpeedDangerous() {
    	Assertions.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

	@Test
	public void testCancelWeatherAdvicePrecipitationDangerous() {
		Assertions.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0, 6.1));
	}

	@Test
	public void testCancelWeatherAdviceWindSpeedConcerningPrecipitationConcerning() {
		Assertions.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(45.1, 4.1));
	}

	@Test
	public void testAllClearWeatherAdviceWindSpeedSafe() {
		Assertions.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(44.9, 0));
	}

	@Test
	public void testWarnWeatherAdviceWindSpeedConcerning() {
		Assertions.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.1, 0.0));
	}

	@Test
	public void testWarnWeatherAdvicePrecipitationConcerning() {
		Assertions.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0, 4.1));
	}

	@Test
	public void testThrowsIllegalArgumentExceptionWindSpeedNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			WeatherAndMathUtils.weatherAdvice(-1, 0);
		});
	}

	@Test
	public void testThrowsIllegalArgumentExceptionPrecipitationNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			WeatherAndMathUtils.weatherAdvice(0, -1);
		});
	}

	// For 100% Coverage
	@Test
	public void testConstructor() {
		WeatherAndMathUtils obj = new WeatherAndMathUtils();
		Assertions.assertNotNull(obj);
	}
}