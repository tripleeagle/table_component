package cz.idc.model;

import java.util.Set;

/**
 * @author lyalival
 */
public class Vendor {
    private String name;
    private Set<SellList> sellLists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SellList> getSellLists() {
        return sellLists;
    }

    public void setSellLists(Set<SellList> sellLists) {
        this.sellLists = sellLists;
    }
}
