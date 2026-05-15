package sit333_week6;

import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradeServiceTest {
    // Basic tests [Right]
    @Test
    public void testInvalidMark() {
        Assertions.assertEquals("Invalid", GradeService.calculateGrade(-1, 100));
    }

    @Test
    public void testInvalidAttendance() {
        Assertions.assertEquals("Invalid", GradeService.calculateGrade(100, -1));
    }

    @Test
    public void testMarkBelow50Fail() {
        Assertions.assertEquals("Fail", GradeService.calculateGrade(49, 100));
    }

    @Test
    public void testMark80AndAboveHighDistinction() {
        Assertions.assertEquals("High Distinction", GradeService.calculateGrade(80, 100));
    }

    @Test
    public void testMark70To79Distinction() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(70, 100));
    }

    @Test
    public void testMark60To69Credit() {
        Assertions.assertEquals("Credit", GradeService.calculateGrade(60, 100));
    }

    @Test
    public void testMark50To59Pass() {
        Assertions.assertEquals("Pass", GradeService.calculateGrade(50, 100));
    }

    @Test
    public void testBelow60AttendanceHighDistinctionToDistinction() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(80, 59));
    }

    @Test
    public void testBelow60AttendanceDistinctionToCredit() {
        Assertions.assertEquals("Credit", GradeService.calculateGrade(70, 59));
    }

    @Test
    public void testBelow60AttendanceCreditToPass() {
        Assertions.assertEquals("Pass", GradeService.calculateGrade(60, 59));
    }

    @Test
    public void testBelow60AttendancePassToFail() {
        Assertions.assertEquals("Fail", GradeService.calculateGrade(50, 59));
    }

    // [Boundary Conditions]
    // Mark and attendance boundaries: 0 <= x <= 100 (-1, 0, 100, 101)
    @Test
    public void testMarkMinMinusInvalid() {
        Assertions.assertEquals("Invalid", GradeService.calculateGrade(-1, 100));
    }

    @Test
    public void testMarkMinLowestValid() {
        Assertions.assertEquals("Fail", GradeService.calculateGrade(0, 100));
    }

    @Test
    public void testMarkMaxHighestValid() {
        Assertions.assertEquals("High Distinction", GradeService.calculateGrade(100, 100));
    }

    @Test
    public void testMarkMaxPlusInvalid() {
        Assertions.assertEquals("Invalid", GradeService.calculateGrade(101, 100));
    }

    @Test
    public void testAttendanceMinMinusInvalid() {
        Assertions.assertEquals("Invalid", GradeService.calculateGrade(100, -1));
    }

    @Test
    public void testAttendanceMinLowestValid() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(100, 0));
    }

    @Test
    public void testAttendanceMaxHighestValid() {
        Assertions.assertEquals("High Distinction", GradeService.calculateGrade(100, 100));
    }

    @Test
    public void testAttendanceMaxPlusInvalid() {
        Assertions.assertEquals("Invalid", GradeService.calculateGrade(100, 101));
    }

    // Pass/Fail boundary: mark = 50
    @Test
    public void testMarkPassBoundaryMinMinusFail() {
        Assertions.assertEquals("Fail", GradeService.calculateGrade(49, 100));
    }

    @Test
    public void testMarkPassBoundaryMinPass() {
        Assertions.assertEquals("Pass", GradeService.calculateGrade(50, 100));
    }

    @Test
    public void testMarkPassBoundaryMinPlusPass() {
        Assertions.assertEquals("Pass", GradeService.calculateGrade(51, 100));
    }

    // Credit boundary: mark = 60
    @Test
    public void testMarkCreditBoundaryMinMinusPass() {
        Assertions.assertEquals("Pass", GradeService.calculateGrade(59, 100));
    }

    @Test
    public void testMarkCreditBoundaryMinCredit() {
        Assertions.assertEquals("Credit", GradeService.calculateGrade(60, 100));
    }

    @Test
    public void testMarkCreditBoundaryMinPlusCredit() {
        Assertions.assertEquals("Credit", GradeService.calculateGrade(61, 100));
    }

    // Distinction boundary: mark = 70
    @Test
    public void testMarkDistinctionBoundaryMinMinusCredit() {
        Assertions.assertEquals("Credit", GradeService.calculateGrade(69, 100));
    }

    @Test
    public void testMarkDistinctionBoundaryMinDistinction() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(70, 100));
    }

    @Test
    public void testMarkDistinctionBoundaryMinPlusDistinction() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(71, 100));
    }

    // High Distinction boundary: mark = 80
    @Test
    public void testMarkHighDistinctionBoundaryMinMinusDistinction() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(79, 100));
    }

    @Test
    public void testMarkHighDistinctionBoundaryMinHighDistinction() {
        Assertions.assertEquals("High Distinction", GradeService.calculateGrade(80, 100));
    }

    @Test
    public void testMarkHighDistinctionBoundaryMinPlusHighDistinction() {
        Assertions.assertEquals("High Distinction", GradeService.calculateGrade(81, 100));
    }

    // Attendance boundary: attendance = 60
    @Test
    public void testAttendanceBoundaryMinMinusPenaltyApplied() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(80, 59));
    }

    @Test
    public void testAttendanceBoundaryMinNoPenalty() {
        Assertions.assertEquals("High Distinction", GradeService.calculateGrade(80, 60));
    }

    @Test
    public void testAttendanceBoundaryMinPlusNoPenalty() {
        Assertions.assertEquals("High Distinction", GradeService.calculateGrade(80, 61));
    }

    // [Inverse Relationships]
    // Mark threshold
    // Case A: Meets threshold
    @Test
    public void testMarkThresholdMeetsPass() {
        Assertions.assertEquals("Pass", GradeService.calculateGrade(50, 100));
    }

    // Case B: Inverse relationship
    @Test
    public void testMarkThresholdInverseFail() {
        Assertions.assertEquals("Fail", GradeService.calculateGrade(49, 100));
    }

    // Attendance threshold
    // Case A: Meets threshold
    @Test
    public void testAttendanceThresholdMeetsNoPenalty() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(75, 60));
    }

    // Case B: Inverse relationship
    @Test
    public void testAttendanceThresholdInversePenaltyApplied() {
        Assertions.assertEquals("Credit", GradeService.calculateGrade(75, 59));
    }

    // Input validation
    // Case A: Valid input
    @Test
    public void testValidInput() {
        Assertions.assertEquals("Distinction", GradeService.calculateGrade(75, 75));
    }

    // Case B: Invalid input
    @Test
    public void testInvalidMarkInput() {
        Assertions.assertEquals("Invalid", GradeService.calculateGrade(-1, 100));
    }

    @Test
    public void testInvalidAttendanceInput() {
        Assertions.assertEquals("Invalid", GradeService.calculateGrade(100, -1));
    }
}