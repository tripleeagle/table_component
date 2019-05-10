package cz.idc.dto;

import cz.idc.model.DataContainer;

/**
 * @author lyalival
 */
public interface ImportConverter<I> {
    DataContainer importData ( I object );
}
