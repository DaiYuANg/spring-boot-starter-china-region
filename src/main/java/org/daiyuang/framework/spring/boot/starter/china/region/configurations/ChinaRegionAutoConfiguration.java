package org.daiyuang.framework.spring.boot.starter.china.region.configurations;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.daiyuang.framework.spring.boot.starter.china.region.base.RegionPojo;
import org.daiyuang.framework.spring.boot.starter.china.region.functional.AreasFunctional;
import org.daiyuang.framework.spring.boot.starter.china.region.functional.CitiesFunctional;
import org.daiyuang.framework.spring.boot.starter.china.region.functional.ProvincesFunctional;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@AutoConfiguration
@EnableConfigurationProperties(ChinaRegionConfigurationProperties.class)
@Slf4j
public class ChinaRegionAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "china.region", name = "enableProvinces", havingValue = "true")
    public ProvincesFunctional provincesFunctional() {
        return new ProvincesFunctional();
    }

    @Bean
    public AreasFunctional areasFunctional() {
        return new AreasFunctional();
    }

    @Bean
    public CitiesFunctional citiesFunctional() {
        return new CitiesFunctional();
    }

    @Bean
    @ConditionalOnBean({RedisAutoConfiguration.class, RedisTemplate.class})
    public RedisTemplate<String, RegionPojo> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        val template = new RedisTemplate<String, RegionPojo>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
