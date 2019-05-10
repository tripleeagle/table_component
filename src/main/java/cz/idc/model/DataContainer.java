package cz.idc.model;

import java.util.Set;

/**
 * @author lyalival
 */
public class DataContainer {
    private Set<Vendor> vendors;
    private Set<Country> counties;

    public Set<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(Set<Vendor> vendors) {
        this.vendors = vendors;
    }

    public Set<Country> getCounties() {
        return counties;
    }

    public void setCounties(Set<Country> counties) {
        this.counties = counties;
    }
}
