package sit333_week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
	public MainTest() {
		System.out.println("MainTest");
	}
	
	@BeforeEach
	public void setup() {
		System.out.println("Before...");
	}
	
	@Test
	public void testStudentIdentity() {
		String studentId = null;
		Assertions.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = null;
		Assertions.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testAssertTrue()
    {
		System.out.println("testAssertTrue...");
        Assertions.assertTrue( true );
    }
	
	@Test
	public void testAssertFalse()
    {
		System.out.println("testAssertFalse...");
        Assertions.assertFalse( !true );
    }
}
