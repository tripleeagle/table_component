package cz.idc.model;

import java.util.*;

/**
 * @author lyalival
 */
public class DataContainer {
    private Map<String,Vendor> vendorMap;
    private Set<Country> countrySet;
    private Set<TimePeriod> timePeriodSet;

    public DataContainer() {
        vendorMap = new HashMap<>();
        countrySet = new HashSet<>();
        timePeriodSet =  new HashSet<>();
    }

    public void addVendor ( Vendor vendor ){
        vendorMap.put(vendor.getName(),vendor);
    }

    public boolean addCountry ( Country country ){
        return countrySet.add(country);
    }

    public boolean addTimePeriod ( TimePeriod timePeriod ){
        return timePeriodSet.add(timePeriod);
    }

    public Map<String, Vendor> getVendorMap() {
        return vendorMap;
    }

    public void setVendorMap(Map<String, Vendor> vendorMap) {
        this.vendorMap = vendorMap;
    }

    public Set<Country> getCountrySet() {
        return countrySet;
    }

    public void setCountrySet(Set<Country> countrySet) {
        this.countrySet = countrySet;
    }

    public Set<TimePeriod> getTimePeriodSet() {
        return timePeriodSet;
    }

    public void setTimePeriodSet(Set<TimePeriod> timePeriodSet) {
        this.timePeriodSet = timePeriodSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataContainer that = (DataContainer) o;
        return vendorMap.equals(that.vendorMap) &&
                countrySet.equals(that.countrySet) &&
                timePeriodSet.equals(that.timePeriodSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorMap, countrySet, timePeriodSet);
    }
}
