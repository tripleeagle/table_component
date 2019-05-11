package cz.idc.model;

import java.util.Objects;

/**
 * @author lyalival
 */
public class SellList {
    private Vendor vendor;
    private Double units;
    private TimePeriod timePeriod;
    private Country country;

    public SellList(Vendor vendor, Double units, TimePeriod timePeriod, Country country) {
        this.vendor = vendor;
        this.units = units;
        this.timePeriod = timePeriod;
        this.country = country;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellList sellList = (SellList) o;
        return units.equals(sellList.units) &&
                timePeriod.equals(sellList.timePeriod) &&
                country.equals(sellList.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendor, units, timePeriod, country);
    }
}
