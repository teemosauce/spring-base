package com.yp.springbase.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yp.springbase.base.framework.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user")
public class User extends BaseEntity {

    private String name;

    private String email; // laun59454@gmail.com

}
