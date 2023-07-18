package org.daiyuang.framework.spring.boot.starter.china.region.functional;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.daiyuang.framework.spring.boot.starter.china.region.base.AbstractRegionFunctional;
import org.daiyuang.framework.spring.boot.starter.china.region.pojo.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

@Slf4j
public class CitiesFunctional extends AbstractRegionFunctional<City> {
    @Value("classpath:cities.json")
    private Resource cities;

    @PostConstruct
    public void init() {
        log.info("Cities initialized");
    }

    @Override
    protected Resource parseFrom() {
        return cities;
    }
}
