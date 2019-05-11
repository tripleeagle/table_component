package cz.idc.controller;

import com.opencsv.CSVReader;
import cz.idc.dto.CSV.CSVImport;
import cz.idc.dto.CSV.model.CSVItem;
import cz.idc.model.DataContainer;

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
        List<CSVItem> csvItems = new ArrayList<>();
        try (
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                csvItems.add(new CSVItem(nextRecord[0],nextRecord[1],nextRecord[2],nextRecord[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return CSVImport.importData(csvItems);
    }


}
