package de.lukaskoerfer.simplepnml;

import java.util.stream.Stream;

public interface Collectable {

    Stream<Collectable> collect();

}
