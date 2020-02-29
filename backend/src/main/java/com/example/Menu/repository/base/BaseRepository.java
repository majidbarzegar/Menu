package com.example.Menu.repository.base;

import com.example.Menu.criteria.base.BaseCriteria;
import com.example.Menu.model.base.BaseModel;
import com.example.Menu.model.base.BaseUser;


import java.util.List;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
public interface BaseRepository<M extends BaseModel,C extends BaseCriteria,I extends Comparable<I>> {
    // get
    M get(I id);

    List<M> get(List<I> ids);

    List<M> get(C criteria);

    M getOne(C criteria);

    M getFirst(C criteria);

    M getLast(C criteria);

    List<I> getIds(C criteria);

    // delete
    Long delete(I id, BaseUser user);

    Long delete(C criteria, BaseUser user);

    Long delete(List<I> ids, BaseUser user);

    // save
    M save(M model,BaseUser user);

    List<M> save(List<M> models,BaseUser user);

    // update
    M update(M model,BaseUser user);

    // filter
    List<M> filter(C criteria);

    // count
    Long getCount(C criteria);

    Long getFilterCount(C criteria);

    Boolean isExist(C criteria);

    Boolean isNotExist(C criteria);

}
