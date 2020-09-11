package de.lukaskoerfer.simplepnml;

/**
 * Marks all petri net elements that have a name
 */
public interface Named {

    /**
     * Gets the name of the element
     * @return
     */
    Label getName();

    /**
     * Sets the name of the element
     * @param name
     */
    void setName(Label name);

}
