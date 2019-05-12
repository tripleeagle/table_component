package cz.idc;

import cz.idc.controller.CSVController;
import cz.idc.controller.HTMLExportController;
import cz.idc.dto.HTML.model.HTMLTable;
import cz.idc.model.DataContainer;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author lyalival
 */
public class TestExportToHTML {
    private static String projectsFolder = System.getProperty ("user.home") + "/Projects/";
    private static String resourcesFolder = "TableComponent/src/test/resources/";
    private static String fileName = "index.html";
    private static String filePath = projectsFolder + resourcesFolder + fileName;

    private final DataContainer dataContainer = CSVController.importCSVFromFile(projectsFolder + resourcesFolder + "data.csv");
    private List<HTMLTable> htmlTableList = HTMLExportController.convertToHTMLList(dataContainer);

    @Test
    public void testExportToHTML(){
        HTMLExportController.exportToHTMLFile(filePath,htmlTableList);
    }

    @Test
    public void testSortByVendorNameAndExportToFile (){
        htmlTableList = HTMLExportController.sortHTMLListByVendor(htmlTableList);
        HTMLExportController.exportToHTMLFile(filePath,htmlTableList);
    }

    @Test
    public void testSortByUnitsAndExportToFile (){
        htmlTableList = HTMLExportController.sortHTMLListByUnits(htmlTableList);
        HTMLExportController.exportToHTMLFile(filePath,htmlTableList);
    }

    @Test
    public void testGettingOrdinalNumberOfVendor(){
        htmlTableList = HTMLExportController.sortHTMLListByVendor(htmlTableList);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("ASUS",htmlTableList.get(0)) == 1);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Acer",htmlTableList.get(0)) == 2);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Apple",htmlTableList.get(0)) == 3);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Dell",htmlTableList.get(0)) == 4);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Fujitsu Siemens",htmlTableList.get(0)) == 5);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Hewlett-Packard",htmlTableList.get(0)) == 6);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Lenovo",htmlTableList.get(0)) == 7);

        //Now sort by count of units and check once again
        htmlTableList = HTMLExportController.sortHTMLListByUnits(htmlTableList);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Apple",htmlTableList.get(0)) == 1);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("ASUS",htmlTableList.get(0)) == 2);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Fujitsu Siemens",htmlTableList.get(0)) == 3);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Lenovo",htmlTableList.get(0)) == 4);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Dell",htmlTableList.get(0)) == 5);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Acer",htmlTableList.get(0)) == 6);
        assert ( HTMLExportController.getOrdinalNumberOfVendor("Hewlett-Packard",htmlTableList.get(0)) == 7);
    }
}
