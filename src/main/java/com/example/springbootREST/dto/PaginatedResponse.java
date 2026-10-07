package com.example.springbootREST.dto;

import java.util.Collection;

public class PaginatedResponse<T> {
    private int page;
    private Collection<T> data;

    public PaginatedResponse(int page, Collection<T> data) {
        this.page = page;
        this.data = data;

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
