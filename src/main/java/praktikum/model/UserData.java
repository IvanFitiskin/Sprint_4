package praktikum.model;

public class UserData {

    private final String firstName;
    private final String secondName;
    private final String address;
    private final String station;
    private final String phoneNumber;

    public UserData(String firstName, String secondName, String address, String station, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getAddress() {
        return address;
    }

    public String getStation() {
        return station;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
