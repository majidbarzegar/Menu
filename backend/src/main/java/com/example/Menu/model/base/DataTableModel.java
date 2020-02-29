package com.example.Menu.model.base;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/

@Getter
public class DataTableModel<M> {
    private final List<M> list;
    private final Long total;

    public DataTableModel() {
        this.list = Collections.emptyList();
        this.total = 0L;
    }

    public DataTableModel(List<M> list, Long total) {
        this.list = list;
        this.total = total;
    }
}
