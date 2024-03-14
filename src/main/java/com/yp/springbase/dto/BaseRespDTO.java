package com.yp.springbase.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.entity.User;

import java.io.Serializable;
import java.util.List;

public class BaseRespDTO<T> implements Serializable {
    private List<T> data;

    private long pageNum;



    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    private long pageSize;

    private long total;

    private long pages;

    private BaseRespDTO(List<T> data, long pageNum, long pageSize, long total, long pages) {
        this.data = data;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }


    public static <T, K> BaseRespDTO<T> make(List<T> data, IPage<K> page) {
       return new BaseRespDTO<T>(data, page.getCurrent(), page.getSize(), page.getTotal(), page.getPages());
    }

//    public static BaseRespDTO make(List<UserRespDTO> userRespDTO, IPage<User> page) {
//    }
}
