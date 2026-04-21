package sit333_week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateUtilTest {
	@Test
	public void testStudentIdentity() {
		String studentId = "220250896";
		Assertions.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Brandon";
		Assertions.assertNotNull("Student name is null", studentName);
	}

	// ==================== Equivalence Class Testing ======================

	// #####################################################################
	// #					D1 + M1 + Y1 + increment					   #
	// #					D1 + M1 + Y1 + decremement					   #
	// #					D1 + M1 + Y2 + increment				   	   #
	// #					D1 + M1 + Y2 + decrement				   	   #
	// #####################################################################
	@Test
	public void testApril20IncrementToApril21_LeapYear() {
		DateUtil date = new DateUtil(20, 4, 2024);
		System.out.println("april20ShouldIncrementToApril21 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(21, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	@Test
	public void testApril20DecrementToApril19_LeapYear() {
		DateUtil date = new DateUtil(20, 4, 2024);
		System.out.println("april20ShouldDecrementToApril19 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(19, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	
	@Test
	public void testApril20IncrementToApril21_NonLeapYear() {
		DateUtil date = new DateUtil(20, 4, 2023);
		System.out.println("april20ShouldIncrementToApril21 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(21, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	@Test
	public void testApril20DecrementToApril19_NonLeapYear() {
		DateUtil date = new DateUtil(20, 4, 2023);
		System.out.println("april20ShouldDecrementToApril19 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(19, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}
	
	// #####################################################################
	// #					D2 + M1 + Y1 + increment					   #
	// #					D2 + M1 + Y1 + decremement					   #
	// #					D2 + M1 + Y2 + increment				   	   #
	// #					D2 + M1 + Y2 + decrement				   	   #
	// #####################################################################
	@Test
	public void testApril29IncrementToApril30_LeapYear() {
		DateUtil date = new DateUtil(29, 4, 2024);
		System.out.println("april29ShouldIncrementToApril30 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(30, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	@Test
	public void testApril29DecrementToApril28_LeapYear() {
		DateUtil date = new DateUtil(29, 4, 2024);
		System.out.println("april29ShouldDecrementToApril28 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(28, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	@Test
	public void testApril29IncrementToApril30_NonLeapYear() {
		DateUtil date = new DateUtil(29, 4, 2023);
		System.out.println("april20ShouldIncrementToApril30 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(30, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	@Test
	public void testApril29DecrementToApril28_NonLeapYear() {
		DateUtil date = new DateUtil(20, 4, 2023);
		System.out.println("april29ShouldDecrementToApril28 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(19, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	// #####################################################################
	// #					D3 + M1 + Y1 + increment					   #
	// #					D3 + M1 + Y1 + decrement					   #
	// #					D3 + M1 + Y2 + increment				   	   #
	// #					D3 + M1 + Y2 + decrement				   	   #
	// #####################################################################
	@Test
	public void testApril30IncrementToMay1_LeapYear() {
		DateUtil date = new DateUtil(30, 4, 2024);
		System.out.println("april30ShouldIncrementToMay1 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(1, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testApril30DecrementToApril29_LeapYear() {
		DateUtil date = new DateUtil(30, 4, 2024);
		System.out.println("april30ShouldDecrementToApril29 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(29, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	@Test
	public void testApril30IncrementToMay1_NonLeapYear() {
		DateUtil date = new DateUtil(30, 4, 2023);
		System.out.println("april30ShouldIncrementToMay1 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(1, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testApril30DecrementToApril29_NonLeapYear() {
		DateUtil date = new DateUtil(30, 4, 2023);
		System.out.println("april30ShouldDecrementToApril29 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(29, date.getDay());
		Assertions.assertEquals(4, date.getMonth());
	}

	// #####################################################################
	// #			D4 + M1 + Y1 (Invalid: April 31)				   	   #
	// #			D4 + M1 + Y2 (Invalid: April 31)				   	   #
	// #####################################################################
	@Test
	public void testApril31_Invalid_LeapYear() {
		System.out.println("april31ShouldBeInvalid");
		Assertions.assertThrows(RuntimeException.class, () -> {
			new DateUtil(31, 4, 2023);
		});
	}

	@Test
	public void testApril31_Invalid_NonLeapYear() {
		System.out.println("april31ShouldBeInvalid");
		Assertions.assertThrows(RuntimeException.class, () -> {
			new DateUtil(31, 4, 2023);
		});
	}

	// #####################################################################
	// #					D1 + M2 + Y1 + increment					   #
	// #					D1 + M2 + Y1 + decrement					   #
	// #					D1 + M2 + Y2 + increment				   	   #
	// #					D1 + M2 + Y2 + decrement				   	   #
	// #####################################################################
	@Test
	public void testMay20IncrementToMay21_LeapYear() {
		DateUtil date = new DateUtil(20, 5, 2024);
		System.out.println("may20ShouldIncrementToMay21 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(21, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay20IncrementToMay19_LeapYear() {
		DateUtil date = new DateUtil(20, 5, 2024);
		System.out.println("may20ShouldDecrementToMay19 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(19, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay20IncrementToMay21_NonLeapYear() {
		DateUtil date = new DateUtil(20, 5, 2023);
		System.out.println("may20ShouldIncrementToMay21 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(21, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay20IncrementToMay19_NonLeapYear() {
		DateUtil date = new DateUtil(20, 5, 2023);
		System.out.println("may20ShouldDecrementToMay19 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(19, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	// #####################################################################
	// #					D2 + M2 + Y1 + increment					   #
	// #					D2 + M2 + Y1 + decrement					   #
	// #					D2 + M2 + Y2 + increment				   	   #
	// #					D2 + M2 + Y2 + decrement				   	   #
	// #####################################################################
	@Test
	public void testMay29IncrementToMay30_LeapYear() {
		DateUtil date = new DateUtil(29, 5, 2024);
		System.out.println("may29ShouldIncrementToMay30 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(30, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay29DecrementToMay28_LeapYear() {
		DateUtil date = new DateUtil(29, 5, 2024);
		System.out.println("may29ShouldDecrementToMay28 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(28, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay29IncrementToMay30_NonLeapYear() {
		DateUtil date = new DateUtil(29, 5, 2023);
		System.out.println("may29ShouldIncrementToMay30 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(30, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay29DecrementToMay28_NonLeapYear() {
		DateUtil date = new DateUtil(29, 5, 2023);
		System.out.println("may29ShouldDecrementToMay28 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(28, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	// #####################################################################
	// #					D3 + M2 + Y1 + increment					   #
	// #					D3 + M2 + Y1 + decrement					   #
	// #					D3 + M2 + Y2 + increment				   	   #
	// #					D3 + M2 + Y2 + decrement				   	   #
	// #####################################################################
	@Test
	public void testMay30IncrementToMay31_LeapYear() {
		DateUtil date = new DateUtil(30, 5, 2024);
		System.out.println("may30ShouldIncrementToMay31 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(31, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay30DecrementToMay29_LeapYear() {
		DateUtil date = new DateUtil(30, 5, 2024);
		System.out.println("may30ShouldDecrementToMay29 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(29, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay30IncrementToMay31_NonLeapYear() {
		DateUtil date = new DateUtil(30, 5, 2023);
		System.out.println("may30ShouldIncrementToMay31 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(31, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay30DecrementToMay29_NonLeapYear() {
		DateUtil date = new DateUtil(30, 5, 2023);
		System.out.println("may30ShouldDecrementToMay29 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(29, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	// #####################################################################
	// #					D4 + M2 + Y1 + increment					   #
	// #					D4 + M2 + Y1 + decrement					   #
	// #					D4 + M2 + Y2 + increment				   	   #
	// #					D4 + M2 + Y2 + decrement				   	   #
	// #####################################################################
	@Test
	public void testMay31IncrementToJune1_LeapYear() {
		DateUtil date = new DateUtil(31, 5, 2024);
		System.out.println("may31ShouldIncrementToJune1 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(1, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMay31DecrementToMay30_LeapYear() {
		DateUtil date = new DateUtil(31, 5, 2024);
		System.out.println("may31ShouldDecrementToMay30 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(30, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay31IncrementToJune1_NonLeapYear() {
		DateUtil date = new DateUtil(31, 5, 2023);
		System.out.println("may31ShouldIncrementToJune1 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(1, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMay31DecrementToMay30_NonLeapYear() {
		DateUtil date = new DateUtil(31, 5, 2023);
		System.out.println("may31ShouldDecrementToMay30 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(30, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	// #####################################################################
	// #					D1 + M3 + Y1 + increment					   #
	// #					D1 + M3 + Y1 + decrement					   #
	// #					D1 + M3 + Y2 + increment				   	   #
	// #					D1 + M3 + Y2 + decrement				   	   #
	// #####################################################################
	@Test
	public void testFebruary20IncrementToFebruary21_LeapYear() {
		DateUtil date = new DateUtil(20, 2, 2024);
		System.out.println("february20ShouldIncrementToFebruary21 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(21, date.getDay());
		Assertions.assertEquals(2, date.getMonth());
	}

	@Test
	public void testFebruary20DecrementToFebruary19_LeapYear() {
		DateUtil date = new DateUtil(20, 2, 2024);
		System.out.println("february20ShouldDecrementToFebruary19 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(19, date.getDay());
		Assertions.assertEquals(2, date.getMonth());
	}

	@Test
	public void testFebruary20IncrementToFebruary21_NonLeapYear() {
		DateUtil date = new DateUtil(20, 2, 2023);
		System.out.println("february20ShouldIncrementToFebruary21 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(21, date.getDay());
		Assertions.assertEquals(2, date.getMonth());
	}

	@Test
	public void testFebruary20DecrementToFebruary19_NonLeapYear() {
		DateUtil date = new DateUtil(20, 2, 2023);
		System.out.println("february20ShouldDecrementToFebruary19 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(19, date.getDay());
		Assertions.assertEquals(2, date.getMonth());
	}

	// #####################################################################
	// #					D2 + M3 + Y1 + increment				   	   #
	// #					D2 + M3 + Y1 + decrement				   	   #
	// #					D2 + M3 + Y2 (Invalid: Non Leap Year)		   #
	// #####################################################################
	@Test
	public void testFebruary29IncremementToMarch1_LeapYear() {
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("february29ShouldIncrementToMarch1 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(1, date.getDay());
		Assertions.assertEquals(3, date.getMonth());
	}

	@Test
	public void testFebruary29DecrementToFebruary28_LeapYear() {
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("february29ShouldIncrementToMarch1 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(28, date.getDay());
		Assertions.assertEquals(2, date.getMonth());
	}

	@Test
	public void testFebruary29_Invalid_NonLeapYear() {
		System.out.println("february29ShouldBeInvalid");
		Assertions.assertThrows(RuntimeException.class, () -> {
			new DateUtil(29, 2, 2023);
		});
	}

	// #####################################################################
	// #			D3 + M3 + Y1 (Invalid: February 30)				   	   #
	// #			D3 + M3 + Y2 (Invalid: February 30)				   	   #
	// #####################################################################
	@Test 
	public void testFebruary30_Invalid_LeapYear() {
		System.out.println("february30ShouldBeInvalid");
		Assertions.assertThrows(RuntimeException.class, () -> {
			new DateUtil(30, 2, 2024);
		});
	}

	@Test 
	public void testFebruary30_Invalid_NonLeapYear() {
		System.out.println("february30ShouldBeInvalid");
		Assertions.assertThrows(RuntimeException.class, () -> {
			new DateUtil(30, 2, 2023);
		});
	}

	// #####################################################################
	// #			D4 + M3 + Y1 (Invalid: February 31)				   	   #
	// #			D4 + M3 + Y2 (Invalid: February 31)				   	   #
	// #####################################################################
	@Test
	public void testFebruary31_Invalid_LeapYear() {
		System.out.println("february31ShouldBeInvalid");
		Assertions.assertThrows(RuntimeException.class, () -> {
			new DateUtil(31, 2, 2024);
		});
	}

	@Test
	public void testFebruary31_Invalid_NonLeapYear() {
		System.out.println("february31ShouldBeInvalid");
		Assertions.assertThrows(RuntimeException.class, () -> {
			new DateUtil(31, 2, 2023);
		});
	}
}