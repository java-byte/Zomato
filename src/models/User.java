package models;

public class User {

    private String name;
    private Gender gender;
    private int phoneNumber;
    private Location location;

    public User(String name, Gender gender, int phoneNumber, Location location) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", phoneNumber=" + phoneNumber +
                ", location=" + location +
                '}';
    }
}
