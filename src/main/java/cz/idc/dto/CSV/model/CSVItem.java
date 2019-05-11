package cz.idc.dto.CSV.model;

/**
 * @author lyalival
 */
public class CSVItem {
    private final String country;
    private final String timeScale;
    private final String vendor;
    private final String units;

    public CSVItem(String country, String timeScale, String vendor, String units) {
        this.country = country;
        this.timeScale = timeScale;
        this.vendor = vendor;
        this.units = units;
    }

    public String getCountry() {
        return country;
    }

    public String getTimeScale() {
        return timeScale;
    }

    public String getVendor() {
        return vendor;
    }

    public String getUnits() {
        return units;
    }
}
