package de.lukaskoerfer.simplepnml;

import java.util.function.Function;
import java.util.stream.Stream;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamUtil {

    public static <Target extends Base, Base> Function<Base, Stream<Target>> ofType(Class<Target> targetType) {
        return value -> targetType.isInstance(value) ? Stream.of(targetType.cast(value)) : Stream.empty();
    }

}
