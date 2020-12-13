package dao;

import exceptions.LocationAlreadyExistsException;
import exceptions.LocationNotExistsException;
import models.Location;

import java.util.HashMap;
import java.util.Map;

public class LocationDAO {

    private static LocationDAO locationDAO;

    private Map<Integer, Location> locationMap = new HashMap<>();

    private LocationDAO(){};

    public static LocationDAO getInstance(){
        if(locationDAO==null){
            locationDAO = new LocationDAO();
        }
        return locationDAO;
    }

    public void addLocation(Location location){
        if(locationMap.containsKey(location.getZipCode())){
            throw new LocationAlreadyExistsException("Location already exists !!");
        }
        locationMap.put(location.getZipCode(), location);
    }

    public Location getLocationFromZipCode(int zipCode){
        if(!locationMap.containsKey(zipCode)){
            throw new LocationNotExistsException("Location doesn't exits for given ZipCode");
        }
        return locationMap.get(zipCode);
    }

    public Map<Integer, Location> getLocationMap() {
        return locationMap;
    }

    public void setLocationMap(Map<Integer, Location> locationMap) {
        this.locationMap = locationMap;
    }
}
