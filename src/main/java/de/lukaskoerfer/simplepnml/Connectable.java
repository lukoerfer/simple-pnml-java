package de.lukaskoerfer.simplepnml;

import lombok.EqualsAndHashCode;

/**
 * Marks all elements that can be connected via arcs
 */
@EqualsAndHashCode(callSuper = true)
public abstract class Connectable extends Identifiable { }
