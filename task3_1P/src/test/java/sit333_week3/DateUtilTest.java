package sit333_week3;

import java.util.Random;

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

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assertions.assertEquals(2, date.getMonth());
        Assertions.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assertions.assertEquals(30, date.getDay());
        Assertions.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}

	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january1ShouldIncremeentToJanuary2 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(2, date.getDay());
		Assertions.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(31, date.getDay());
		Assertions.assertEquals(12, date.getMonth());
	}

	// ============================ Section A ==============================
	// 1A
	@Test
	public void testMinJune1ShouldDecrementToJuly31() {
		DateUtil date = new DateUtil(1, 6, 1994);
		System.out.println("june1ShouldDecremementToMay31 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(31, date.getDay());
		Assertions.assertEquals(5, date.getMonth());
	}

	// 2A
	@Test
	public void testJune2DecrementToJune1() {
		DateUtil date = new DateUtil(2, 6, 1994);
		System.out.println("june2ShouldDecremementToJune1 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(1, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 3A
	@Test
	public void testJune15DecrementToJune14() {
		DateUtil date = new DateUtil(15, 6, 1994);
		System.out.println("june15ShouldDecremementToJune14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 4A
	@Test
	public void testJune30DecrementToJune29() {
		DateUtil date = new DateUtil(30, 6, 1994);
		System.out.println("june30ShouldDecremementToJune29 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(29, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 5A - Invalid Date
	@Test
	public void testJune31DecrementToJune30() {
		DateUtil date = new DateUtil(31, 6, 1994);
		System.out.println("june31ShouldDecremementToJune30 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(30, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 6A
	@Test
	public void testJanuary15DecrementToJanuary14() {
		DateUtil date = new DateUtil(15, 1, 1994);
		System.out.println("january15ShouldDecremementToJanuary14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(1, date.getMonth());
	}

	// 7A
	@Test
	public void testFebruary15DecrementToFebruary14() {
		DateUtil date = new DateUtil(15, 2, 1994);
		System.out.println("february15ShouldDecremementToFebruary14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(2, date.getMonth());
	}

	// 8A
	@Test
	public void testNovember15DecrementToNovember14() {
		DateUtil date = new DateUtil(15, 11, 1994);
		System.out.println("november15ShouldDecremementToNovember14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(11, date.getMonth());
	}

	// 9A
	@Test
	public void testDecember15DecrementToDecember14() {
		DateUtil date = new DateUtil(15, 12, 1994);
		System.out.println("december15ShouldDecremementToDecember14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(12, date.getMonth());
	}

	// 10A
	@Test
	public void testJune15DecrementToJune14_1700() {
		DateUtil date = new DateUtil(15, 6, 1700);
		System.out.println("june15ShouldDecremementToJune14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 11A
	@Test
	public void testJune15DecrementToJune14_1701() {
		DateUtil date = new DateUtil(15, 6, 1701);
		System.out.println("june15ShouldDecremementToJune14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 12A
	@Test
	public void testJune15DecrementToJune14_2023() {
		DateUtil date = new DateUtil(15, 6, 2023);
		System.out.println("june15ShouldDecremementToJune14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 13A
	@Test
	public void testJune15DecrementToJune14_2024() {
		DateUtil date = new DateUtil(15, 6, 2024);
		System.out.println("june15ShouldDecremementToJune14 > " + date);
		date.decrement();
		System.out.println(date);
		Assertions.assertEquals(14, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// ============================ Section B ==============================
	// 1B
	@Test
	public void testMinJune1ShouldIncrementToJune2() {
		DateUtil date = new DateUtil(1, 6, 1994);
		System.out.println("june1ShouldIncremeentToJune2 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(2, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 2B
	@Test
	public void testJune2IncrementToJune3() {
		DateUtil date = new DateUtil(2, 6, 1994);
		System.out.println("june2ShouldIncremeentToJune3 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(3, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 3B
	@Test
	public void testJune15IncrementToJune16() {
		DateUtil date = new DateUtil(15, 6, 1994);
		System.out.println("june15ShouldIncremeentToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 4B
	@Test
	public void testJune30IncrementToJuly1() {
		DateUtil date = new DateUtil(30, 6, 1994);
		System.out.println("june30ShouldIncremeentToJuly1 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(1, date.getDay());
		Assertions.assertEquals(7, date.getMonth());
	}

	// 5B - Invalid Date
	@Test
	public void testJune31IncrementToJuly1() {
		DateUtil date = new DateUtil(31, 6, 1994);
		System.out.println("june31ShouldIncremeentToJuly1 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(1, date.getDay());
		Assertions.assertEquals(7, date.getMonth());
	}

	// 6B
	@Test
	public void testJanuary15IncrementToJanuary16() {
		DateUtil date = new DateUtil(15, 1, 1994);
		System.out.println("january15ShouldIncremeentToJanuary16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(1, date.getMonth());
	}

	// 7B
	@Test
	public void testFebruary15IncrementToFebruary16() {
		DateUtil date = new DateUtil(15, 2, 1994);
		System.out.println("february15ShouldIncremeentToFebruary16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(2, date.getMonth());
	}

	// 8B
	@Test
	public void testNovember15IncrementToNovember16() {
		DateUtil date = new DateUtil(15, 11, 1994);
		System.out.println("november15ShouldIncremeentToNovember16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(11, date.getMonth());
	}

	// 9B
	@Test
	public void testDecember15IncrementToDecember16() {
		DateUtil date = new DateUtil(15, 12, 1994);
		System.out.println("december15ShouldIncremeentToDecember16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(12, date.getMonth());
	}

	// 10B
	@Test
	public void testJune15IncrementToJune16_1700() {
		DateUtil date = new DateUtil(15, 6, 1700);
		System.out.println("june15ShouldIncremeentToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 11B
	@Test
	public void testJune15IncrementToJune16_1701() {
		DateUtil date = new DateUtil(15, 6, 1701);
		System.out.println("june15ShouldIncremeentToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}
	
	// 12B
	@Test
	public void testJune15IncrementToJune16_2023() {
		DateUtil date = new DateUtil(15, 6, 2023);
		System.out.println("june15ShouldIncremeentToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}

	// 13B
	@Test
	public void testJune15IncrementToJune16_2024() {
		DateUtil date = new DateUtil(15, 6, 2024);
		System.out.println("june15ShouldIncremeentToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assertions.assertEquals(16, date.getDay());
		Assertions.assertEquals(6, date.getMonth());
	}
}
