package cz.idc.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lyalival
 */
public class DataContainer {
    private Map<String,Vendor> vendors;
    private Map<String,Country> counties;

    public DataContainer() {
        vendors = new HashMap<String, Vendor>();
        counties = new HashMap<String, Country>();
    }

    public void addVendor ( Vendor vendor ){
        vendors.put(vendor.getName(),vendor);
    }

    public Map<String, Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(Map<String, Vendor> vendors) {
        this.vendors = vendors;
    }

    public void addCountry ( Country country ){
        counties.put(country.getName(),country);
    }

    public Map<String, Country> getCounties() {
        return counties;
    }

    public void setCounties(Map<String, Country> counties) {
        this.counties = counties;
    }
}
