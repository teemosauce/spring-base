package com.yp.springbase.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yp.springbase.entity.BaseEntity;

public class BaseQueryDTO {

    private int pageNum;

    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public static <T extends BaseQueryDTO, K extends BaseEntity> IPage<K> page(T query) {
        return new Page<K>(query.getPageNum(), query.getPageSize());
    }
}
