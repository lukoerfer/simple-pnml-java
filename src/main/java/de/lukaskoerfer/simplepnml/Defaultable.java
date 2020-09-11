package de.lukaskoerfer.simplepnml;

import java.util.List;

/**
 * Encapsulates petri net elements that may be in default state
 */
public interface Defaultable {

    /**
     * Evaluates whether an element is in default state
     * @return
     */
    boolean isDefault();

    static String requireNonDefaultElseNull(String value) {
        return value == null || value.isEmpty() ? null : value;
    }

    static Double requireNonDefaultElseNull(double value) {
        return value == 0.0 ? null : value;
    }

    static <T> List<T> requireNonDefaultElseNull(List<T> values) {
        return values == null || values.isEmpty() ? null : values;
    }

    static <T extends Defaultable> T requireNonDefaultElseNull(T value) {
        return value == null || value.isDefault() ? null : value;
    }

}
