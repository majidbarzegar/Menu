package com.example.Menu.repository.base;

import com.example.Menu.criteria.base.BaseCriteria;
import com.example.Menu.model.base.BaseModel;
import com.example.Menu.model.base.BaseUser;


import java.util.List;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
public abstract class BaseRepositoryImpl<M extends BaseModel<I>,C extends BaseCriteria<I>,I extends Comparable<I>> implements BaseRepository<M,C,I> {
    @Override
    public M get(I id) {
        return null;
    }

    @Override
    public List<M> get(List<I> ids) {
        return null;
    }

    @Override
    public List<M> get(C criteria) {
        return null;
    }

    @Override
    public M getOne(C criteria) {
        return null;
    }

    @Override
    public M getFirst(C criteria) {
        return null;
    }

    @Override
    public M getLast(C criteria) {
        return null;
    }

    @Override
    public List<I> getIds(C criteria) {
        return null;
    }

    @Override
    public Long delete(I id, BaseUser user) {
        return null;
    }

    @Override
    public Long delete(C criteria, BaseUser user) {
        return null;
    }

    @Override
    public Long delete(List<I> ids, BaseUser user) {
        return null;
    }

    @Override
    public M save(M model, BaseUser user) {
        return null;
    }

    @Override
    public List<M> save(List<M> models, BaseUser user) {
        return null;
    }

    @Override
    public M update(M model, BaseUser user) {
        return null;
    }

    @Override
    public Long getCount(C criteria) {
        return null;
    }

    @Override
    public List<M> filter(C criteria) {
        return null;
    }

    @Override
    public Long getFilterCount(C criteria) {
        return null;
    }

    @Override
    public Boolean isExist(C criteria) {
        return null;
    }

    @Override
    public Boolean isNotExist(C criteria) {
        return null;
    }
}

