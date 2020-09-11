package de.lukaskoerfer.simplepnml;

/**
 * Marks all graphical representations that have a fill
 */
public interface Filled {

    /**
     *
     * @return
     */
    Fill getFill();

    /**
     *
     * @param fill
     */
    void setFill(Fill fill);

}
