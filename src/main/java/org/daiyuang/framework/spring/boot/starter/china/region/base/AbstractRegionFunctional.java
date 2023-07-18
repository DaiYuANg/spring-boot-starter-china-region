package org.daiyuang.framework.spring.boot.starter.china.region.base;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractRegionFunctional<Region> {

    protected final CopyOnWriteArraySet<Region> internalRegion = new CopyOnWriteArraySet<>();

    @PostConstruct
    @Order(0)
    void initialize() {
        internalRegion.addAll(parsed());
    }

    public Optional<Region> search(Predicate<Region> predicate) {
        return internalRegion.stream()
                .filter(predicate)
                .findFirst();
    }

    public Set<Region> searchAll(Predicate<Region> predicate) {
        return internalRegion.stream()
                .filter(predicate).collect(Collectors.toSet());
    }

    public Set<Region> getAll() {
        return Collections.unmodifiableSet(internalRegion);
    }

    protected abstract Resource parseFrom();

    @SneakyThrows
    protected Set<Region> parsed() {
        return Collections.emptySet();
//        return gson.fromJson(parseFrom().getContentAsString(StandardCharsets.UTF_8),
//                new TypeToken<Set<Region>>() {
//                }.getType());
    }
}
