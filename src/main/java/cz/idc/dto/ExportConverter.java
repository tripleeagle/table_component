package cz.idc.dto;

import cz.idc.model.DataContainer;

/**
 * @author lyalival
 */
public interface ExportConverter<O> {
    O exportData ( DataContainer dataContainer );
}
