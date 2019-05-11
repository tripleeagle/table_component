package cz.idc.model;

import java.util.*;

/**
 * @author lyalival
 */
public class Vendor {
    private String name;
    private List<SellList> sellLists;

    public Vendor( String name ) {
        this.name = name;
        sellLists = new ArrayList<SellList>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSellList(SellList sellList ) { sellLists.add(sellList); }

    public List<SellList> getSellLists() {
        return sellLists;
    }

    public void setSellLists(List<SellList> sellLists) {
        this.sellLists = sellLists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return name.equals(vendor.name) &&
                sellLists.equals(vendor.sellLists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellLists);
    }
}
