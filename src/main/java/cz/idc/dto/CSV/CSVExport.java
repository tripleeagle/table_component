package cz.idc.dto.CSV;

import cz.idc.dto.CSV.model.CSVRow;
import cz.idc.model.DataContainer;

import java.io.IOException;
import java.util.List;

/**
 * @author lyalival
 */
public class CSVExport {

    private static List<CSVRow> convertData (DataContainer dataContainer ) {
        //TODO
        throw new UnsupportedOperationException("TODO");
    }


    public static void exportToCSV ( DataContainer dataContainer, String fileNamePath ) throws IOException {
        //TODO 1) using convertData (dataContainer) convert data
        //TODO 2) Export them to the fileNamePath, e.g. using http://opencsv.sourceforge.net/#writing_from_a_list_of_beans
        throw new UnsupportedOperationException("TODO");
    }
}
