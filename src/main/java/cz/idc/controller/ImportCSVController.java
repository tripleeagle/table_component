package cz.idc.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import cz.idc.dto.CSV.CSVImport;
import cz.idc.dto.CSV.model.CSVRow;
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
public class ImportCSVController {

    public static DataContainer importCSV (String filePath ){
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
}
