package cz.idc.dto;

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
}
