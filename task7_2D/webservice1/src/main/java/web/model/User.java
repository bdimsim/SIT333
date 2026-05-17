package web.model;

import java.time.LocalDate;

public class User {
    String fName;
    String lName;
    String email;
    String password;
    LocalDate dob;

    public User(
        String fName, 
        String lName, 
        String email, 
        String password,
        LocalDate dob
    ) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }
}