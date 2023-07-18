package org.daiyuang.framework.spring.boot.starter.china.region.functional;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(
        classes = {SpringBootApplication.class,}
)
@RunWith(SpringRunner.class)
@Slf4j
class AreasFunctionalTest {

    @Resource
    private ProvincesFunctional provincesFunctional;

    @Test
    void parseFrom() {
    }
}