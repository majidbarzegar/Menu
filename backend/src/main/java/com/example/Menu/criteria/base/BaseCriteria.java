package com.example.Menu.criteria.base;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/

@Getter
@Setter
public abstract class BaseCriteria<I extends Comparable<I>> {
    private Long page;
    private Long size;
    private List<I> idIn;
    private List<I> idNotIn;

    public BaseCriteria() {
    }

    public BaseCriteria(Long page, Long size) {
        this.page = page;
        this.size = size;
    }
}
