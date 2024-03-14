package com.yp.springbase.dto.req;


import com.yp.springbase.dto.BaseQueryDTO;

public class UserQueryDTO extends BaseQueryDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
