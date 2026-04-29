package web.service;

public class MathQuestionService {
	// Calculate Q1 result.
	public static double q1Addition(String number1, String number2) {
		boolean isNumber1Blank = (number1 == null || number1.isBlank());
		boolean isNumber2Blank = (number2 == null || number2.isBlank());

		// Empty or whitespace check
		if (isNumber1Blank || isNumber2Blank) return Double.NaN;
	
		// Number format check
		try {
			return Double.valueOf(number1) + Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}
	
	// Calculate Q2 result.
	public static double q2Subtraction(String number1, String number2) {
		boolean isNumber1Blank = (number1 == null || number1.isBlank());
		boolean isNumber2Blank = (number2 == null || number2.isBlank());

		// Empty or whitespace check
		if (isNumber1Blank || isNumber2Blank) return Double.NaN;

		// Number format check
		try {
			return Double.valueOf(number1) - Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}
}