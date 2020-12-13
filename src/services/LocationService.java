package services;

import dao.LocationDAO;
import models.Location;

public class LocationService {
    private static LocationService locationService;
    LocationDAO locationDAO = LocationDAO.getInstance();
    private LocationService(){}

    public static LocationService getInstance(){
        if(locationService==null){
            locationService = new LocationService();
        }
        return locationService;
    }

    public void addLocation(Location location){
        locationDAO.addLocation(location);
    }
}
