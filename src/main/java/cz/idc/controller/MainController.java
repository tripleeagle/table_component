package cz.idc.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import cz.idc.dto.CSV.CSVImport;
import cz.idc.dto.CSV.model.CSVRow;
import cz.idc.dto.HTML.HTMLExport;
import cz.idc.dto.SalesFigure;
import cz.idc.model.*;

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

    public static void exportToHTML ( DataContainer dataContainer ){
        String projectsFolder = System.getProperty ("user.home") + "/Projects/";
        String resourcesFolder = "TableComponent/src/test/resources/";
        String fileName = "index.html";
        try {
            HTMLExport.exportToHTML(dataContainer,projectsFolder + resourcesFolder + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SalesFigure getSalesFigure (DataContainer data, String vendorName, TimePeriod timePeriod ){
        Double totalUnits = getTotalUnits( data, null,  timePeriod );
        Double vendorUnits = getVendorUnits( data, vendorName, null, timePeriod );
        return new SalesFigure(vendorUnits,vendorUnits / totalUnits  );
    }

    public static SalesFigure getSalesFigure (DataContainer data, String vendorName, Country country, TimePeriod timePeriod ){
        Double totalUnits = getTotalUnits( data, country, timePeriod );
        Double vendorUnits = getVendorUnits( data, vendorName, country, timePeriod );
        return new SalesFigure(vendorUnits,vendorUnits / totalUnits  );
    }

    public static Double getTotalUnits(DataContainer data, Country country, TimePeriod timePeriod) {
        Double totalUnits = 0.0;
        for ( String vendorName : data.getVendorMap().keySet() ) {
            totalUnits += getVendorUnits(data, vendorName, country, timePeriod);
        }
        return totalUnits;
    }

    private static Double getVendorUnits(DataContainer data, String vendorName, Country country, TimePeriod timePeriod) {
        Double vendorUnits = 0.0;
        Vendor vendor = data.getVendorMap().get(vendorName);
        for (SellList sellList : vendor.getSellLists())
        {
            if ( country != null && !sellList.getCountry().equals(country)){
                continue;
            }
            if ( timePeriod.equals(sellList.getTimePeriod()) ){
                vendorUnits += sellList.getUnits();
            }
        }
        return vendorUnits;
    }

}
