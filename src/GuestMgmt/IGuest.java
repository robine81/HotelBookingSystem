package GuestMgmt;

import BookingSystem.IBooker;

public interface IGuest extends IBooker {
    public String getFirstName();
    public String getLastName();
    public String getSsn();
    public String getEmail();
    public String getPhoneNumber();
    public IBooker getBooker();
}
