package cz.idc.controller;

import cz.idc.dto.HTML.HTMLExport;
import cz.idc.dto.HTML.model.HTMLRow;
import cz.idc.dto.HTML.model.HTMLTable;
import cz.idc.model.DataContainer;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lyalival
 */
public class HTMLExportController {

    public static void exportToHTMLFile (String filePath, List<HTMLTable> htmlTableList){
        try {
            HTMLExport.exportToHTML(htmlTableList,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<HTMLTable> convertToHTMLList ( DataContainer dataContainer ){
        return HTMLExport.convertData(dataContainer);
    }

    public static int getOrdinalNumberOfVendor ( String vendorName, HTMLTable htmlTable ){
        for ( int i = 0; i < htmlTable.getHtmlRows().size(); i++ ){
            if ( vendorName.equals(htmlTable.getHtmlRows().get(i).getVendor()))
                return i + 1;
        }
        return -1;
    }

    public static List<HTMLTable> sortHTMLListByVendor ( List<HTMLTable> htmlTableList ){
        for ( HTMLTable htmlTable : htmlTableList ){
            Collections.sort(htmlTable.getHtmlRows(), Comparator.comparing(HTMLRow::getVendor));
        }
        return htmlTableList;
    }

    public static List<HTMLTable> sortHTMLListByUnits ( List<HTMLTable> htmlTableList ){
        for ( HTMLTable htmlTable : htmlTableList ){
            Collections.sort(htmlTable.getHtmlRows(), (o1, o2) -> {
                Double o1Double = Double.parseDouble(o1.getUnits().replaceAll(",",""));
                Double o2Double = Double.parseDouble(o2.getUnits().replaceAll(",",""));
                return o1Double < o2Double ? -1 : ((o1Double == o2Double) ? 0 : 1);
            });
        }
        return htmlTableList;
    }
}
