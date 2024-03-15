package com.yp.springbase.dto.res;

import lombok.Data;

import java.util.Date;

@Data
public class UserRespDTO  {

    private long id;

    private String name;

    private Date createTime;

    private Date updateTime;

}
