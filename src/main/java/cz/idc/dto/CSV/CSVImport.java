package cz.idc.dto.CSV;

import cz.idc.dto.CSV.model.CSVRow;
import cz.idc.model.*;

import java.util.List;

/**
 * @author lyalival
 */
public class CSVImport {

    public static DataContainer importData(List<CSVRow> dataList) {
        DataContainer dataContainer = new DataContainer();
        for ( int i = 0; i < dataList.size(); i++) {
            Vendor vendor = getVendor(dataList.get(i).getVendor(), dataContainer);
            Country country = getCountry(dataList.get(i).getCountry(), dataContainer);
            TimePeriod timePeriod = getTimePeriod (dataList.get(i).getTimeScale());
            Double units = Double.parseDouble(dataList.get(i).getUnits());

            SellList sellList = new SellList(vendor,units,timePeriod,country);
            vendor.addSellList(sellList);

            if ( !dataContainer.getVendors().containsKey(vendor.getName())){
                dataContainer.addVendor(vendor);
            }

            if ( !dataContainer.getCounties().containsKey(vendor.getName())){
                dataContainer.addCountry(country);
            }
        }
        return dataContainer;
    }

    private static TimePeriod getTimePeriod( String timeScale ) {
        String tmp = timeScale.replaceAll("\\s+","");
        String [] tmpArr = tmp.split("Q");
        return new TimePeriod(Integer.parseInt(tmpArr[0]),Integer.parseInt(tmpArr[1]));
    }

    private static Vendor getVendor ( String name, DataContainer dataContainer ){
        Vendor vendor = dataContainer.getVendors().get(name);
        if ( vendor == null )
            vendor = new Vendor(name);
        return vendor;
    }

    private static Country getCountry (String name, DataContainer dataContainer ){
        Country country = dataContainer.getCounties().get(name);
        if ( country == null )
            country = new Country(name);
        return country;
    }
}
