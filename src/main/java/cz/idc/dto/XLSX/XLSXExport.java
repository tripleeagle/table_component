package cz.idc.dto.XLSX;

import cz.idc.dto.XLSX.model.XLSXRow;
import cz.idc.model.DataContainer;

import java.io.IOException;
import java.util.List;

/**
 * @author lyalival
 */
public class XLSXExport {
    private static List<XLSXRow> convertData (DataContainer dataContainer ) {
        //TODO
        throw new UnsupportedOperationException("TODO");
    }


    public static void exportToXLS ( DataContainer dataContainer, String fileNamePath ) throws IOException {
        //TODO 1) using convertData (dataContainer) convert data
        //TODO 2) Export them to the fileNamePath, e.g. https://medium.com/@ssaurel/generating-microsoft-excel-xlsx-files-in-java-9508d1b521d9
        throw new UnsupportedOperationException("TODO");
    }
}
