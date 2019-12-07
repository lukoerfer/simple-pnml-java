package de.lukaskoerfer.simplepnml;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

class Collector {

    private final Stream.Builder<Collectable> builder = Stream.builder();

    private Collector(Collectable current) {
        builder.add(current);
    }

    public static Collector create(Collectable current) {
        return new Collector(current);
    }

    public Collector collect(Collectable child) {
        if (child != null) {
            child.collect().forEach(builder::add);
        }
        return this;
    }

    public <T extends Collectable> Collector collect(Collection<T> children) {
        if (children != null) {
            children.stream()
                .filter(Objects::nonNull)
                .flatMap(Collectable::collect)
                .forEach(builder::add);
        }
        return this;
    }

    public Stream<Collectable> build() {
        return builder.build();
    }

}
