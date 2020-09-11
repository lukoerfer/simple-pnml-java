package de.lukaskoerfer.simplepnml;

/**
 * Marks elements that are graphically represented by an edge
 */
public interface Edge {

    /**
     *
     * @return
     */
    EdgeGraphics getGraphics();

    /**
     *
     * @param graphics
     */
    void setGraphics(EdgeGraphics graphics);

}
