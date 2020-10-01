package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;

/**
 * Marks elements those sub-elements can be collected
 */
public interface Collectable {

    /**
     * Recursively collects all sub-elements of this element
     * @return All PNML elements inside this element
     */
    Stream<Collectable> collect();

}
