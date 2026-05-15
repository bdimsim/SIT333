package sit333_week9;

import java.time.LocalDateTime;

public class SubmissionService {
    static final long MAX_FILE_SIZE_MB = 250;

    // Prevents constructor access from outside the class
    // This is a utility class. Instance is not needed since all methods are static.
    private SubmissionService() { }

 public static SubmissionStatus validate(Submission submission) {
        String fileName = submission.getFileName();
        String fileExtension = getFileExtension(fileName);
        long fileSize = submission.getFileSize(); // In MB
        LocalDateTime submittedAt = submission.getSubmittedAt();
        LocalDateTime dueDate = submission.getDueDate();

        if (fileName == null || fileName.isEmpty())
            return SubmissionStatus.FILE_REQUIRED;

        if (fileExtension == null || !isSupportedExtension(fileExtension))
            return SubmissionStatus.INVALID_FILE_TYPE;

        if (fileSize > MAX_FILE_SIZE_MB)
            return SubmissionStatus.FILE_TOO_LARGE;

        if (submittedAt.isAfter(dueDate))
            return SubmissionStatus.LATE;

        return SubmissionStatus.ON_TIME;
    }

    private static String getFileExtension(String fileName) {
        // First Check if fileName is null or empty, if so return null
        if (fileName == null || fileName.isEmpty())
            return null;

        // Get index of the dot in the file name
        int dotIndex = fileName.lastIndexOf('.');

        // If not present, index will be -1, so return null
        // If the dot is the first char (Index = 0), return null because this is not a valid fileName
        if (dotIndex == -1 || dotIndex == 0)
            return null;
        
        // Get the file extension by taking the substring from the dot index to the end of the fileName string
        String fileExtension = fileName.substring(dotIndex).toLowerCase();

        // Check if the fileName contains an extension (if length <= 1, the filename only contains a dot)
        if (fileExtension.length() <= 1)
            return null;

        return fileExtension;
    }

    private static boolean isSupportedExtension(String fileExtension) {
        return ".pdf".equals(fileExtension) 
            || ".java".equals(fileExtension) 
            || ".txt".equals(fileExtension);
    }
}













