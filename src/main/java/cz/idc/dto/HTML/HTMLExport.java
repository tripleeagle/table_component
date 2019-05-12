package cz.idc.dto.HTML;

import cz.idc.controller.MainController;
import cz.idc.dto.HTML.model.HTMLRow;
import cz.idc.dto.HTML.model.HTMLTable;
import cz.idc.dto.SalesFigure;
import cz.idc.model.Country;
import cz.idc.model.DataContainer;
import cz.idc.model.TimePeriod;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lyalival
 */
public class HTMLExport {

    public static List<HTMLTable> convertData(DataContainer dataContainer) {
        List<HTMLTable> htmlTables = new ArrayList<>();
        for (Country country : dataContainer.getCountrySet()) {
            for (TimePeriod timePeriod : dataContainer.getTimePeriodSet()) {
                HTMLTable htmlTable = new HTMLTable(country.getName(), timePeriod);
                for (String vendorName : dataContainer.getVendorMap().keySet()) {
                    SalesFigure salesFigure = MainController.getSalesFigure(dataContainer, vendorName, country, timePeriod);
                    htmlTable.addHTMLRow(new HTMLRow(vendorName, salesFigure.getUnits(), salesFigure.getShare()));
                }
                htmlTables.add(htmlTable);
            }
        }
        return htmlTables;
    }

    public static void exportToHTML(List<HTMLTable> htmlTables, String filenNamePath) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(filenNamePath));

        addHTMLHeader(printWriter);
        int i = 1;
        for (HTMLTable htmlTable : htmlTables) {
            addTableTitle(printWriter, i, htmlTable.getCountry(), htmlTable.getPeriod());
            addTableHeader(printWriter);
            Double totalUnits = 0.0;
            for (HTMLRow htmlRow : htmlTable.getHtmlRows()) {
                printWriter.append("<tr>");
                addTableColumnItem(printWriter, htmlRow.getVendor());
                addTableColumnItem(printWriter, htmlRow.getUnits());
                totalUnits += getDouble(htmlRow.getUnits());
                addTableColumnItem(printWriter, htmlRow.getShare());
                printWriter.append("</tr>");
            }

            //Add total number
            printWriter.append("<tr>");
            addTableColumnItem(printWriter, "Total");
            DecimalFormat decimalFormatFormat = new DecimalFormat("#,##0");
            addTableColumnItem(printWriter, decimalFormatFormat.format(totalUnits));
            addTableColumnItem(printWriter, "100%");
            printWriter.append("</tr>");

            addTableFooter(printWriter);
            i++;
        }
        addHTMLFooter(printWriter);
        printWriter.close();
    }

    private static Double getDouble(String num) {
        num = num.replaceAll(",", "");
        return Double.parseDouble(num);
    }

    private static void addHTMLHeader(PrintWriter printWriter) {
        printWriter.append("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>Table Component</title>\n" +
                "  <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>\n" +
                "<body>\n");
    }

    private static void addTableTitle(PrintWriter printWriter, int i, String country, String period) {
        printWriter.append("<h3>Table " + i + ", PC Quarterly Market Share, " + country + ", " + period + "</h3>");
    }

    private static void addTableColumnItem(PrintWriter printWriter, String string) {
        printWriter.append("<td>");
        printWriter.append(string);
        printWriter.append("</td>");
    }

    private static void addTableHeader(PrintWriter printWriter) {
        printWriter.println("<table style=\"width:500px\">\n" +
                "  <tr>\n" +
                "    <th>Vendor</th>\n" +
                "    <th>Units</th> \n" +
                "    <th>Share</th>\n" +
                "  </tr>");
    }

    private static void addTableFooter(PrintWriter printWriter) {
        printWriter.append("</table>");
    }

    private static void addHTMLFooter(PrintWriter printWriter) {
        printWriter.append("</body>\n" +
                "</html>");
    }
}
