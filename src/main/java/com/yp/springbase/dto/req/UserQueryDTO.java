package com.yp.springbase.dto.req;


import com.yp.springbase.base.framework.BaseQueryDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryDTO extends BaseQueryDTO {

    private String name;

}
