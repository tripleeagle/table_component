package cz.idc.controller;

import cz.idc.dto.SalesFigure;
import cz.idc.model.*;

/**
 * @author lyalival
 */
public class MainController {

    public static SalesFigure getSalesFigure(DataContainer data, String vendorName, TimePeriod timePeriod) {
        Double totalUnits = getTotalUnits(data, null, timePeriod);
        Double vendorUnits = getVendorUnits(data, vendorName, null, timePeriod);
        return new SalesFigure(vendorUnits, vendorUnits / totalUnits);
    }

    public static SalesFigure getSalesFigure(DataContainer data, String vendorName, Country country, TimePeriod timePeriod) {
        Double totalUnits = getTotalUnits(data, country, timePeriod);
        Double vendorUnits = getVendorUnits(data, vendorName, country, timePeriod);
        return new SalesFigure(vendorUnits, vendorUnits / totalUnits);
    }

    public static Double getTotalUnits(DataContainer data, Country country, TimePeriod timePeriod) {
        Double totalUnits = 0.0;
        for (String vendorName : data.getVendorMap().keySet()) {
            totalUnits += getVendorUnits(data, vendorName, country, timePeriod);
        }
        return totalUnits;
    }

    private static Double getVendorUnits(DataContainer data, String vendorName, Country country, TimePeriod timePeriod) {
        Double vendorUnits = 0.0;
        Vendor vendor = data.getVendorMap().get(vendorName);
        for (SellList sellList : vendor.getSellLists()) {
            if (country != null && !sellList.getCountry().equals(country)) {
                continue;
            }
            if (timePeriod.equals(sellList.getTimePeriod())) {
                vendorUnits += sellList.getUnits();
            }
        }
        return vendorUnits;
    }

}
