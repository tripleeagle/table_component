package cz.idc.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import cz.idc.dto.CSV.CSVImport;
import cz.idc.dto.CSV.model.CSVRow;
import cz.idc.dto.SalesFigure;
import cz.idc.model.DataContainer;
import cz.idc.model.SellList;
import cz.idc.model.TimePeriod;
import cz.idc.model.Vendor;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lyalival
 */
public class MainController {
    public static DataContainer importCSV ( String filePath ){
        List<CSVRow> csvRows = new ArrayList<>();
        try (
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
        ){
            csvRows  = new CsvToBeanBuilder(reader).withType(CSVRow.class).build().parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return CSVImport.importData(csvRows);
    }

    public static SalesFigure getSalesFigure (DataContainer data, String vendorName, TimePeriod timePeriod ){
        Double totalUnits = getTotalUnits( data, timePeriod );
        Double vendorUnits = getVendorUnits( data, vendorName, timePeriod );
        return new SalesFigure(vendorUnits,totalUnits / vendorUnits);
    }

    private static Double getTotalUnits(DataContainer data, TimePeriod timePeriod) {
        Double totalUnits = 0.0;
        for ( String vendorName : data.getVendors().keySet() ) {
            totalUnits += getVendorUnits(data, vendorName, timePeriod);
        }
        return totalUnits;
    }

    private static Double getVendorUnits(DataContainer data, String vendorName, TimePeriod timePeriod) {
        Double vendorUnits = 0.0;
        Vendor vendor = data.getVendors().get(vendorName);
        for (SellList sellList : vendor.getSellLists())
        {
            if ( timePeriod.equals(sellList.getTimePeriod()) ){
                vendorUnits += sellList.getUnits();
            }
        }
        return vendorUnits;
    }

}
