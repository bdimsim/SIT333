package web.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathQuestionServiceUnitTest {
	// ####################################################################
	// # 						Baseline tests			  				  #		
	// ####################################################################
	// # 					S1 + S1 + q1Addition						  #
	// # 					S1 + S1 + q2Subtraction                       #
	// ####################################################################
	@Test
	public void testDecimalDecimalQ1AdditionValid() {
		double result = MathQuestionService.q1Addition("2.3", "2.3");
		Assertions.assertEquals(4.6, result, 0.0);
	}

	@Test
	public void testDecimalDecimalQ2SubtractionValid() {
		double result = MathQuestionService.q2Subtraction("2.3", "2.3");
		Assertions.assertEquals(0.0, result, 0.0);
	}

	// ####################################################################
	// #							Set A						 		  #
	// ####################################################################
	// # 					S1 + S2 + q1Addition						  #
	// # 					S1 + S3 + q1Addition                 		  #
	// # 					S1 + S4 + q1Addition                 		  #
	// # 					S1 + S5 + q1Addition                 		  #
	// # 					S1 + S6 + q1Addition                 		  #
	// ####################################################################
	@Test
	public void testDecimalWholeNumberQ1AdditionValid() {
		double result = MathQuestionService.q1Addition("2.3", "1");
		Assertions.assertEquals(3.3, result, 0.0);
	}

	@Test
	public void testDecimalZeroQ1AdditionValid() {
		double result = MathQuestionService.q1Addition("2.3", "0");
		Assertions.assertEquals(2.3, result, 0.0);
	}

	@Test
	public void testDecimalNullQ1AdditionNaN() {
		double result = MathQuestionService.q1Addition("2.3", null);
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	@Test
	public void testDecimalEmptyQ1AdditionNaN() {
		double result = MathQuestionService.q1Addition("2.3", "");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	@Test
	public void testDecimalNonNumericQ1AdditionNaN() {
		double result = MathQuestionService.q1Addition("2.3", "abc");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	// ####################################################################
	// #							Set A						 		  #
	// ####################################################################
	// # 					S1 + S2 + q2Subtraction 					  #
	// # 					S1 + S3 + q2Subtraction                 	  #
	// # 					S1 + S4 + q2Subtraction                 	  #
	// # 					S1 + S5 + q2Subtraction                 	  #
	// # 					S1 + S6 + q2Subtraction                 	  #
	// ####################################################################
	@Test
	public void testDecimalWholeNumberQ2SubtractionValid() {
		double result = MathQuestionService.q2Subtraction("2.3", "1");
		Assertions.assertEquals(1.3, result, 1e-15);
	}

	@Test
	public void testDecimalZeroQ2SubtractionValid() {
		double result = MathQuestionService.q2Subtraction("2.3", "0");
		Assertions.assertEquals(2.3, result, 0.0);
	}

	@Test
	public void testDecimalNullQ2SubtractionNaN() {
		double result = MathQuestionService.q2Subtraction("2.3", null);
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	@Test
	public void testDecimalEmptyQ2SubtractionNaN() {
		double result = MathQuestionService.q2Subtraction("2.3", "");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	@Test
	public void testDecimalNonNumericQ2SubtractionNaN() {
		double result = MathQuestionService.q2Subtraction("2.3", "abc");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	// ####################################################################
	// #							Set B						 		  #
	// ####################################################################
	// # 					S2 + S1 + q1Addition						  #
	// # 					S3 + S1 + q1Addition                 		  #
	// # 					S4 + S1 + q1Addition                 		  #
	// # 					S5 + S1 + q1Addition                 		  #
	// # 					S6 + S1 + q1Addition                 		  #
	// ####################################################################
	@Test
	public void testWholeNumberDecimalQ1AdditionValid() {
		double result = MathQuestionService.q1Addition("1", "2.3");
		Assertions.assertEquals(3.3, result, 0.0);
	}

	@Test
	public void testZeroDecimalQ1AdditionValid() {
		double result = MathQuestionService.q1Addition("0", "2.3");
		Assertions.assertEquals(2.3, result, 0.0);
	}

	@Test
	public void testNullDecimalQ1AdditionNaN() {
		double result = MathQuestionService.q1Addition(null, "2.3");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	@Test
	public void testEmptyDecimalQ1AdditionNaN() {
		double result = MathQuestionService.q1Addition("", "2.3");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	@Test
	public void testNonNumericDecimalQ1AdditionNaN() {
		double result = MathQuestionService.q1Addition("abc", "2.3");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}
	
	// ####################################################################
	// #							Set B						 		  #
	// ####################################################################
	// # 					S2 + S1 + q2Subtraction 					  #
	// # 					S3 + S1 + q2Subtraction                 	  #
	// # 					S4 + S1 + q2Subtraction                 	  #
	// # 					S5 + S1 + q2Subtraction                 	  #
	// # 					S6 + S1 + q2Subtraction                 	  #
	// ####################################################################
	@Test
	public void testWholeNumberDecimalQ2SubtractionValid() {
		double result = MathQuestionService.q2Subtraction("1", "2.3");
		Assertions.assertEquals(-1.3, result, 1e-15);
	}

	@Test
	public void testZeroDecimalQ2SubtractionValid() {
		double result = MathQuestionService.q2Subtraction("0", "2.3");
		Assertions.assertEquals(-2.3, result, 0.0);
	}

	@Test
	public void testNullDecimalQ2SubtractionNaN() {
		double result = MathQuestionService.q2Subtraction(null, "2.3");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	@Test
	public void testEmptyDecimalQ2SubtractionNaN() {
		double result = MathQuestionService.q2Subtraction("", "2.3");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}

	@Test
	public void testNonNumericDecimalQ2SubtractionNaN() {
		double result = MathQuestionService.q2Subtraction("abc", "2.3");
		Assertions.assertEquals(Double.NaN, result, 0.0);
	}
}