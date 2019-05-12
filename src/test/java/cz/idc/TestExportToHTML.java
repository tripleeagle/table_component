package cz.idc;

import cz.idc.controller.HTMLExportController;
import cz.idc.controller.ImportCSVController;
import cz.idc.controller.MainController;
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

    @Test
    public void testExportToHTML(){
        DataContainer dataContainer = ImportCSVController.importCSV(projectsFolder + resourcesFolder + "data.csv");
        List<HTMLTable> htmlTableList = HTMLExportController.convertToHTMLList(dataContainer);
        HTMLExportController.exportToHTMLFile(htmlTableList);
    }

    @Test
    public void testSortByVendorNameAndExportToFile (){
        DataContainer dataContainer = ImportCSVController.importCSV(projectsFolder + resourcesFolder + "data.csv");
        List<HTMLTable> htmlTableList = HTMLExportController.convertToHTMLList(dataContainer);
        htmlTableList = HTMLExportController.sortHTMLListByVendor(htmlTableList);
        HTMLExportController.exportToHTMLFile(htmlTableList);
    }

    @Test
    public void testSortByUnitsAndExportToFile (){
        DataContainer dataContainer = ImportCSVController.importCSV(projectsFolder + resourcesFolder + "data.csv");
        List<HTMLTable> htmlTableList = HTMLExportController.convertToHTMLList(dataContainer);
        htmlTableList = HTMLExportController.sortHTMLListByUnits(htmlTableList);
        HTMLExportController.exportToHTMLFile(htmlTableList);
    }
}
