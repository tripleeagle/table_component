package cz.idc;

import cz.idc.controller.MainController;
import cz.idc.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author lyalival
 */
public class TestImportCSV {
    String projectsFolder = System.getProperty ("user.home") + "/Projects/";
    String resourcesFolder = "TableComponent/src/test/resources/";

    @Test
    public void test(){
        DataContainer dataContainer = MainController.importCSV(projectsFolder + resourcesFolder + "data.csv");
        assertNotNull(dataContainer);
        DataContainer dataContainerRef = getRefDataContainer();
        assert( dataContainer.getCounties().equals(dataContainerRef.getCounties()));
        assert ( dataContainer.getVendors().equals(dataContainerRef.getVendors()));
        assert( dataContainer.equals(dataContainerRef));
    }

    private DataContainer getRefDataContainer() {
        DataContainer dataContainerRef = new DataContainer();
        Country slovakia = new Country("Slovakia");
        Country czechia = new Country("Czech Republic");
        dataContainerRef.addCountry(slovakia);
        dataContainerRef.addCountry(czechia);

        Vendor acer = new Vendor("Acer");
        acer.addSellList(new SellList(acer,4.669835539,new TimePeriod(2010,4),slovakia));
        acer.addSellList(new SellList(acer,9570.718105,new TimePeriod(2010,3),czechia));
        acer.addSellList(new SellList(acer,1806.205378,new TimePeriod(2010,3),slovakia));
        acer.addSellList(new SellList(acer,1502.421083,new TimePeriod(2010,4),czechia));
        dataContainerRef.addVendor(acer);

        Vendor apple = new Vendor("Apple");
        apple.addSellList(new SellList(apple,266.7584542,new TimePeriod(2010,4),czechia));
        apple.addSellList(new SellList(apple,529.2660577,new TimePeriod(2010,3),slovakia));
        apple.addSellList(new SellList(apple,218.2171404,new TimePeriod(2010,3),czechia));
        apple.addSellList(new SellList(apple,101.5495842,new TimePeriod(2010,4),slovakia));
        dataContainerRef.addVendor(apple);

        Vendor asus = new Vendor("ASUS");
        asus.addSellList(new SellList(asus,1323.507139,new TimePeriod(2010,3),czechia));
        asus.addSellList(new SellList(asus,26.07985635,new TimePeriod(2010,4),slovakia));
        asus.addSellList(new SellList(asus,1190.772949,new TimePeriod(2010,4),czechia));
        asus.addSellList(new SellList(asus,54.99802235,new TimePeriod(2010,3),slovakia));
        dataContainerRef.addVendor(asus);

        Vendor dell = new Vendor("Dell");
        dell.addSellList(new SellList(dell,2525.011404,new TimePeriod(2010,4),slovakia));
        dell.addSellList(new SellList(dell,8267.033639,new TimePeriod(2010,3),czechia));
        dell.addSellList(new SellList(dell,11455.09902,new TimePeriod(2010,4),czechia));
        dell.addSellList(new SellList(dell,2137.856193,new TimePeriod(2010,3),slovakia));
        dataContainerRef.addVendor(dell);

        Vendor fujitsu = new Vendor("Fujitsu Siemens");
        fujitsu.addSellList(new SellList(fujitsu,2924.742632,new TimePeriod(2010,3),czechia));
        fujitsu.addSellList(new SellList(fujitsu,134.6914108,new TimePeriod(2010,4),slovakia));
        fujitsu.addSellList(new SellList(fujitsu,107.1375207,new TimePeriod(2010,3),slovakia));
        fujitsu.addSellList(new SellList(fujitsu,2499.507088,new TimePeriod(2010,4),czechia));
        dataContainerRef.addVendor(fujitsu);

        Vendor hp = new Vendor("Hewlett-Packard");
        hp.addSellList(new SellList(hp,2505.010854,new TimePeriod(2010,3),slovakia));
        hp.addSellList(new SellList(hp,4205.018526,new TimePeriod(2010,4),czechia));
        hp.addSellList(new SellList(hp,5001.504421,new TimePeriod(2010,4),slovakia));
        hp.addSellList(new SellList(hp,11050.90046,new TimePeriod(2010,3),czechia));
        dataContainerRef.addVendor(hp);

        Vendor lenovo = new Vendor("Lenovo");
        lenovo.addSellList(new SellList(lenovo,2648.973238,new TimePeriod(2010,4),slovakia));
        lenovo.addSellList(new SellList(lenovo,4343.112732,new TimePeriod(2010,3),czechia));
        lenovo.addSellList(new SellList(lenovo,459.9392434,new TimePeriod(2010,3),slovakia));
        lenovo.addSellList(new SellList(lenovo,1293.532261,new TimePeriod(2010,4),czechia));
        dataContainerRef.addVendor(lenovo);

        return dataContainerRef;
    }

}
