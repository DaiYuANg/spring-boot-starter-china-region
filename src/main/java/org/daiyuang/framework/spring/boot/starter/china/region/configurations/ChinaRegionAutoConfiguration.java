package org.daiyuang.framework.spring.boot.starter.china.region.configurations;

import lombok.extern.slf4j.Slf4j;
import org.daiyuang.framework.spring.boot.starter.china.region.adaptor.JpaAdaptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(ChinaRegionConfigurationProperties.class)
@Slf4j
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class ChinaRegionAutoConfiguration {
    @Bean
    @ConditionalOnBean(JpaProperties.class)
    public JpaAdaptor jpaAdaptor() {
        return new JpaAdaptor();
    }

//    @Bean
//    @ConditionalOnBean(SqlSessionFactoryBeanCustomizer)
}
