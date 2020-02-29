package com.example.Menu.service.base;

import com.example.Menu.criteria.base.BaseCriteria;
import com.example.Menu.model.base.BaseModel;
import com.example.Menu.model.base.BaseUser;
import com.example.Menu.model.base.DataTableModel;
import com.example.Menu.viewmodel.base.BaseViewModel;

import java.util.List;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
public interface BaseService<M extends BaseModel<I>,C extends BaseCriteria<I>,V extends BaseViewModel<I>,I extends Comparable<I>> {
    M get(I id);

    Long delete(I id, BaseUser user);

    M save(V viewModel, BaseUser user);

    List<M> save(List<V> viewModels,BaseUser user);

    M update(V viewModel,BaseUser user);

    List<M> getAll(C criteria);

    DataTableModel<M> filter(C criteria,BaseUser user);

    M viewToModel(V viewModel);

    V modelToView(M model);

    M viewToExistModel(V viewModel,M model);


}
