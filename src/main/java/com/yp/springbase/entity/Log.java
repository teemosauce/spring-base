package com.yp.springbase.entity;

import com.yp.springbase.base.framework.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Log extends BaseEntity {
    private String message;
}
