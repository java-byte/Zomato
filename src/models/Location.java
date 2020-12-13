package models;

public class Location {

    private String locationName;
    private int zipCode;

    public Location(String locationName, int zipCode) {
        this.locationName = locationName;
        this.zipCode = zipCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
