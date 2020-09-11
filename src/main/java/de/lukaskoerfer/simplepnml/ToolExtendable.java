package de.lukaskoerfer.simplepnml;

import java.util.List;

/**
 * Marks elements that can be extended with tool-specific elements
 */
public interface ToolExtendable {

    /**
     * Gets the tool-specific elements related to this element
     * @return
     */
    List<ToolSpecific> getToolSpecifics();

    /**
     * Sets the tool-specific elements related to this element
     * @param toolSpecificData
     */
    void setToolSpecifics(List<ToolSpecific> toolSpecificData);

}
