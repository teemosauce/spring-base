package com.yp.springbase.base.framework;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageRespDTO<T> implements Serializable {
    private T records;

    private long pageNum;

    private long pageSize;

    private long total;

    private long pages;

    private PageRespDTO(T records, long pageNum, long pageSize, long total, long pages) {
        this.records = records;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }

    public static <T, K> PageRespDTO<T> make(T records, IPage<K> page) {
       return new PageRespDTO<T>(records, page.getCurrent(), page.getSize(), page.getTotal(), page.getPages());
    }
}
