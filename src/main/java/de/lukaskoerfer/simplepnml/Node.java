package de.lukaskoerfer.simplepnml;

/**
 * Marks elements that are graphically represented by a node
 */
public interface Node {

    /**
     * Gets the graphical representation of the node element
     * @return
     */
    NodeGraphics getGraphics();

    /**
     * Sets the graphical representation of the node element
     * @param graphics
     */
    void setGraphics(NodeGraphics graphics);

}
