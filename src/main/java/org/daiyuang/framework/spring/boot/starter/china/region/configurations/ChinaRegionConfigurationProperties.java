package org.daiyuang.framework.spring.boot.starter.china.region.configurations;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "china.region")
@Data
@ToString
public class ChinaRegionConfigurationProperties {

    String year = "2023";
}
