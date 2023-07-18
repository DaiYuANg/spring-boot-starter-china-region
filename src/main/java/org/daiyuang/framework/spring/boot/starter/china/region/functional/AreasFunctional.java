package org.daiyuang.framework.spring.boot.starter.china.region.functional;

import lombok.extern.slf4j.Slf4j;
import org.daiyuang.framework.spring.boot.starter.china.region.base.AbstractRegionFunctional;
import org.daiyuang.framework.spring.boot.starter.china.region.pojo.Area;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AreasFunctional extends AbstractRegionFunctional<Area> {
    @Value("classpath:areas.json")
    private Resource areas;

    @Override
    protected Resource parseFrom() {
        return areas;
    }
}
