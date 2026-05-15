package sit333_week9;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class SubmissionServiceTest {
    @Test
    public void testRejectMissingFile() {
        Submission submission = new Submission(
            null,
            10,
            LocalDateTime.of(2026, 5, 14, 12, 0),
            LocalDateTime.of(2026, 5, 14, 23, 59)
        );

        SubmissionStatus status = SubmissionService.validate(submission);
        Assertions.assertEquals(SubmissionStatus.FILE_REQUIRED, status);
    }

    @Test
    public void testRejectInvalidExtensionType() {
        Submission submission = new Submission(
            "assignment.exe",
            10,
            LocalDateTime.of(2026, 5, 14, 12, 0),
            LocalDateTime.of(2026, 5, 14, 23, 59)
        );

        SubmissionStatus status = SubmissionService.validate(submission);
        Assertions.assertEquals(SubmissionStatus.INVALID_FILE_TYPE, status);
    }

    @Test
    public void testRejectFileOver250MB() { 
        Submission submission = new Submission(
            "assignment.pdf",
            300, // 300 MB
            LocalDateTime.of(2026, 5, 14, 12, 0),
            LocalDateTime.of(2026, 5, 14, 23, 59)
        );

        SubmissionStatus status = SubmissionService.validate(submission);
        Assertions.assertEquals(SubmissionStatus.FILE_TOO_LARGE, status);
    }

    @Test
    public void testAcceptLateSubmission() { 
        Submission submission = new Submission(
            "assignment.pdf",
            10,
            LocalDateTime.of(2026, 5, 15, 0, 0), // After due date
            LocalDateTime.of(2026, 5, 14, 23, 59)
        );
    
        SubmissionStatus status = SubmissionService.validate(submission);
        Assertions.assertEquals(SubmissionStatus.LATE, status);
    }

    @Test
    public void testAcceptOnTimeSubmission() { 
        Submission submission = new Submission(
            "assignment.pdf",
            10,
            LocalDateTime.of(2026, 5, 14, 12, 0), // Before due date
            LocalDateTime.of(2026, 5, 14, 23, 59)
        );

        SubmissionStatus status = SubmissionService.validate(submission);
        Assertions.assertEquals(SubmissionStatus.ON_TIME, status);
    }
} 