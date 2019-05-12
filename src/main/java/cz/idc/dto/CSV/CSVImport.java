package cz.idc.dto.CSV;

import com.opencsv.bean.CsvToBeanBuilder;
import cz.idc.dto.CSV.model.CSVRow;
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
public class CSVImport {

    private static DataContainer convertData(List<CSVRow> dataList) {
        DataContainer dataContainer = new DataContainer();
        for ( int i = 0; i < dataList.size(); i++) {
            Vendor vendor = getVendor(dataList.get(i).getVendor(), dataContainer);
            Country country = new Country(dataList.get(i).getCountry());
            TimePeriod timePeriod = getTimePeriod (dataList.get(i).getTimeScale());
            Double units = Double.parseDouble(dataList.get(i).getUnits());

            SellList sellList = new SellList(vendor,units,timePeriod,country);
            vendor.addSellList(sellList);

            if ( !dataContainer.getVendorMap().containsKey(vendor.getName())){
                dataContainer.addVendor(vendor);
            }

            dataContainer.addTimePeriod(timePeriod);
            dataContainer.addCountry(country);
        }
        return dataContainer;
    }

    public static DataContainer importFromFile (String filePath) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        List<CSVRow> csvRows = new CsvToBeanBuilder(reader).withType(CSVRow.class).build().parse();
        return CSVImport.convertData(csvRows);
    }

    private static TimePeriod getTimePeriod( String timeScale ) {
        String tmp = timeScale.replaceAll("\\s+","");
        String [] tmpArr = tmp.split("Q");
        return new TimePeriod(Integer.parseInt(tmpArr[0]),Integer.parseInt(tmpArr[1]));
    }

    private static Vendor getVendor ( String name, DataContainer dataContainer ){
        Vendor vendor = dataContainer.getVendorMap().get(name);
        if ( vendor == null )
            vendor = new Vendor(name);
        return vendor;
    }


}
