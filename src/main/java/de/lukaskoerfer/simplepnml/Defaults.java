package de.lukaskoerfer.simplepnml;

import java.util.List;

public interface Defaults {

    boolean isDefault();

    static String requireNonDefaultElseNull(String value) {
        return value.isEmpty() ? null : value;
    }

    static Double requireNonDefaultElseNull(double value) {
        return value == 0.0 ? null : value;
    }

    static <T> List<T> requireNonDefaultElseNull(List<T> values) {
        return values.isEmpty() ? null : values;
    }

    static <T extends Defaults> T requireNonDefaultElseNull(T value) {
        return value.isDefault() ? null : value;
    }

}
