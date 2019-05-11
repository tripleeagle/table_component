package cz.idc.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimePeriod that = (TimePeriod) o;
        return year == that.year &&
                quater == that.quater;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, quater);
    }
}
