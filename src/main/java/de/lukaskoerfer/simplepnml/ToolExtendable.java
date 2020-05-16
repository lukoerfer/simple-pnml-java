package de.lukaskoerfer.simplepnml;

import java.util.List;

public interface ToolExtendable {

    List<ToolSpecific> getToolSpecificData();

    void setToolSpecificData(List<ToolSpecific> toolSpecificData);

}
