package de.lukaskoerfer.simplepnml;

/**
 * Marks all graphical representations that have a line
 */
public interface Lined {

    /**
     *
     * @return
     */
    Line getLine();

    /**
     *
     * @param line
     */
    void setLine(Line line);

}
