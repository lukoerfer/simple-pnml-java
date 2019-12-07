package de.lukaskoerfer.simplepnml;

import lombok.experimental.UtilityClass;

import java.util.function.Function;
import java.util.stream.Stream;

@UtilityClass
public class StreamUtil {

    public static <Target extends Base, Base> Function<Base, Stream<Target>> ofType(Class<Target> targetType) {
        return value -> targetType.isInstance(value) ? Stream.of(targetType.cast(value)) : Stream.empty();
    }

}
