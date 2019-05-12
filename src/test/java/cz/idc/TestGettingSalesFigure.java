package cz.idc;

import cz.idc.controller.CSVController;
import cz.idc.controller.MainController;
import cz.idc.dto.SalesFigure;
import cz.idc.model.DataContainer;
import cz.idc.model.TimePeriod;
import org.junit.jupiter.api.Test;

/**
 * @author lyalival
 */
public class TestGettingSalesFigure {
    private static String projectsFolder = System.getProperty("user.home") + "/Projects/";
    private static String resourcesFolder = "TableComponent/src/test/resources/";

    @Test
    public void testSalesFigure() {
        DataContainer dataContainer = CSVController.importCSVFromFile(projectsFolder + resourcesFolder + "data.csv");
        SalesFigure salesFigureAcerRef = new SalesFigure(11376.923483, 0.251153726);
        SalesFigure salesFigureAcer = MainController.getSalesFigure(dataContainer, "Acer", new TimePeriod(2010, 3));
        assert (salesFigureAcer.equals(salesFigureAcerRef));
    }
}
