package de.lukaskoerfer.simplepnml;

import lombok.experimental.UtilityClass;

@UtilityClass
class StringUtil {

    static boolean isEmptyOrWhitespace(String input) {
        return input == null || input.trim().length() < 1;
    }

}
