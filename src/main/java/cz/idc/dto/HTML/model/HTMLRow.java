package cz.idc.dto.HTML.model;

import java.text.DecimalFormat;

/**
 * @author lyalival
 */
public class HTMLRow {
    private String vendor;
    private String units;
    private String share;

    public HTMLRow(String vendor, Double units, Double share) {
        this.vendor = vendor;
        DecimalFormat unitsFormat = new DecimalFormat("#,##0");
        DecimalFormat shareFormat = new DecimalFormat("#,##0.0");
        this.units = unitsFormat.format(units);
        this.share = shareFormat.format(share * 100) + "%";
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }
}
