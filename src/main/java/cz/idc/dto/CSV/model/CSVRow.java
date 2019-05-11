package cz.idc.dto.CSV.model;

import com.opencsv.bean.CsvBindByName;

/**
 * @author lyalival
 */
public class CSVRow {

    @CsvBindByName(column = "Country")
    private String country;

    @CsvBindByName(column = "Timescale")
    private String timeScale;

    @CsvBindByName(column = "Vendor")
    private String vendor;

    @CsvBindByName(column = "Units")
    private String units;

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
