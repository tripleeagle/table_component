package cz.idc.model;

/**
 * @author lyalival
 */
public class TimePeriod {
    private int year;
    private int quater;

    public TimePeriod(int year, int quater) {
        this.year = year;
        this.quater = quater;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuater() {
        return quater;
    }

    public void setQuater(int quater) {
        this.quater = quater;
    }
}
