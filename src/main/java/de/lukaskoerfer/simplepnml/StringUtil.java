package de.lukaskoerfer.simplepnml;

import lombok.experimental.UtilityClass;

@UtilityClass
class StringUtil {

    public static boolean isEmptyOrWhitespace(String input) {
        return input == null || input.trim().length() < 1;
    }

}
