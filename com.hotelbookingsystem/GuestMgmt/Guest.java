package GuestMgmt;

import BookingSystem.IBooker;

import java.util.ArrayList;
import java.util.*;
import java.time.LocalDate;

public class Guest implements IGuest {
    private String firstName;
    private String lastName;
    private String ssn;
    private String email;
    private String phoneNumber;
    private List<LocalDate> visitHistory;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    {
        this.visitHistory = new ArrayList<>();
    }

    public Guest(String firstName, String lastName, String ssn, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
