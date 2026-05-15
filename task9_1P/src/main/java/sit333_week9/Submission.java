package sit333_week9;

import java.time.LocalDateTime;

public class Submission {
    private String fileName;
    private long fileSize;
    private LocalDateTime submittedAt;
    private LocalDateTime dueDate;

    // Constructor
    public Submission(
        String fileName, 
        long fileSize, 
        LocalDateTime submittedAt, 
        LocalDateTime dueDate
    ) {
        this.fileName = fileName;
        this.fileSize = fileSize; // MB
        this.submittedAt = submittedAt;
        this.dueDate = dueDate;
    }

    // Getters
    public String getFileName() { return fileName; }
    public long getFileSize() { return fileSize; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public LocalDateTime getDueDate() { return dueDate; }
}