package cz.idc.controller;

import cz.idc.dto.CSV.CSVImport;
import cz.idc.model.DataContainer;

import java.io.IOException;

/**
 * @author lyalival
 */
public class CSVController {

    public static DataContainer importCSVFromFile(String filePath) {
        DataContainer dataContainer = new DataContainer();
        try {
            dataContainer = CSVImport.importFromFile(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataContainer;
    }

    /**
     * TODO using HTMLExport.exportToHTML(...) the dataContainer to the filePath
     */
    public static void exportToCSVFile(String filePath, DataContainer dataContainer) {
        throw new UnsupportedOperationException("TODO");
    }

}
