package org.daiyuang.framework.spring.boot.starter.china.region.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.daiyuang.framework.spring.boot.starter.china.region.base.RegionPojo;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class Area extends RegionPojo {
    private Integer cityCode;

    private Integer provinceCode;
}
