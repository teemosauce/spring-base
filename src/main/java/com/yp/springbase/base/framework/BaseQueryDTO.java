package com.yp.springbase.base.framework;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class BaseQueryDTO {

    private int pageNumber;

    private int pageSize;


    public static <T extends BaseQueryDTO, K extends BaseEntity> IPage<K> page(T query) {

        if (query.getPageNumber() <= 0) {
            query.setPageNumber(1);
        }

        if (query.getPageSize() <= 0) {
            query.setPageSize(50);
        }

        return new Page<K>(query.getPageNumber(), query.getPageSize());
    }
}
