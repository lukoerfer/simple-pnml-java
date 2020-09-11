package de.lukaskoerfer.simplepnml;

import lombok.NonNull;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

class Collector {

    private final Stream.Builder<Collectable> builder;

    public Collector(@NonNull Collectable parent) {
        builder = Stream.<Collectable>builder().add(parent);
    }

    public Collector include(@NonNull Collectable child) {
        child.collect().forEach(builder::add);
        return this;
    }

    public <T extends Collectable> Collector include(@NonNull Collection<T> children) {
        children.stream()
            .filter(Objects::nonNull)
            .flatMap(Collectable::collect)
            .forEach(builder::add);
        return this;
    }

    public Stream<Collectable> collect() {
        return builder.build();
    }

}
