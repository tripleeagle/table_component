package cz.idc;

import cz.idc.controller.MainController;
import cz.idc.model.DataContainer;
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


    }

}
