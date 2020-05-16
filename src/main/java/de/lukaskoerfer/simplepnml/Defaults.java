package de.lukaskoerfer.simplepnml;

public interface Defaults {

    boolean isDefault();

    static String requireNonDefault(String value) {
        return value.isEmpty() ? null : value;
    }

    static Double requireNonDefault(double value) {
        return value == 0.0 ? null : value;
    }

    static <T extends Defaults> T requireNonDefault(T value) {
        return value.isDefault() ? null : value;
    }

}
