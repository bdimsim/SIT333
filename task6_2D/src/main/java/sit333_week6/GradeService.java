package sit333_week6;

public class GradeService {
    public static String calculateGrade(int mark, int attendance) {
        if (mark < 0 || mark > 100 || attendance < 0 || attendance > 100) return "Invalid";
        if (mark < 50) return "Fail";

        String base;

        if (mark >= 80) base = "High Distinction";
        else if (mark >= 70) base = "Distinction";
        else if (mark >= 60) base = "Credit";
        else base = "Pass";

        if (attendance < 60) {
            if (base.equals("High Distinction")) return "Distinction";
            if (base.equals("Distinction")) return "Credit";
            if (base.equals("Credit")) return "Pass";
            if (base.equals("Pass")) return "Fail";
        }

        return base;
    }
}