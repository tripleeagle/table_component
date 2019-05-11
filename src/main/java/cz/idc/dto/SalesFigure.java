package cz.idc.dto;

import java.util.Objects;

/**
 * @author lyalival
 */
public class SalesFigure {
    private final Double units;
    private final Double share;

    public SalesFigure(Double units, Double share) {
        this.units = units;
        this.share = share;
    }

    public Double getUnits() {
        return units;
    }

    public Double getShare() {
        return share;
    }

    @Override
    public boolean equals(Object o) {
        double tolarete = 10E-5;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesFigure that = (SalesFigure) o;

        return Math.abs(units - that.units) < tolarete &&
                Math.abs(share - that.share) < tolarete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(units, share);
    }
}
