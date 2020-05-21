package de.lukaskoerfer.simplepnml;

import java.util.List;

public interface ToolExtendable {

    List<ToolSpecific> getToolSpecifics();

    void setToolSpecifics(List<ToolSpecific> toolSpecificData);

}
