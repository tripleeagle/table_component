package cz.idc.dto.HTML.model;

import cz.idc.model.TimePeriod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyalival
 */
public class HTMLTable {
    private String country;
    private String period;
    private List<HTMLRow> htmlRows;

    public HTMLTable(String country, TimePeriod period) {
        htmlRows = new ArrayList<>();
        this.country = country;
        this.period =  "" + period.getQuater() + "Q" + period.getYear();
    }

    public void addHTMLRow ( HTMLRow htmlRow ){
        htmlRows.add(htmlRow);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setPeriod(TimePeriod period) {
        this.period =  "" + period.getQuater() + "Q" + period.getYear();
    }

    public List<HTMLRow> getHtmlRows() {
        return htmlRows;
    }

    public void setHtmlRows(List<HTMLRow> htmlRows) {
        this.htmlRows = htmlRows;
    }
}
