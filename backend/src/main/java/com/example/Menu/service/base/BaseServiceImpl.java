package com.example.Menu.service.base;

import com.example.Menu.criteria.base.BaseCriteria;
import com.example.Menu.model.base.BaseModel;
import com.example.Menu.model.base.BaseUser;
import com.example.Menu.model.base.DataTableModel;
import com.example.Menu.repository.base.BaseRepository;
import com.example.Menu.viewmodel.base.BaseViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
public abstract class BaseServiceImpl<M extends BaseModel<I>,C extends BaseCriteria<I>,V extends BaseViewModel<I>,R extends BaseRepository<M,C,I>,I extends Comparable<I>> implements BaseService<M,C,V,I> {

    @Autowired
    private R repository;

    // get
    public M get(I id){
        return repository.get(id);
    }

    public List<M> get(List<I> ids){
        return repository.get(ids);
    }

    public List<M> get(C criteria){
        return repository.get(criteria);
    }

    public M getOne(C criteria){
        return repository.getOne(criteria);
    }

    public M getFirst(C criteria){
        return repository.getFirst(criteria);
    }

    public M getLast(C criteria){
        return repository.getLast(criteria);
    }

    public List<I> getIds(C criteria){ return repository.getIds(criteria);}

    // delete

    @Transactional
    public Long delete(C criteria , BaseUser user){
        List<M> models = this.repository.get(criteria);
        return this.deleteModels(models,user);
    }
    @Transactional
    public Long delete(List<I> ids , BaseUser user){
        List<M> models = this.repository.get(ids);
        return this.deleteModels(models,user);
    }

    @Override
    public Long delete(I id, BaseUser user) {
        return this.delete(Collections.singletonList(id),user);
    }

    private Long deleteModels(List<M> models, BaseUser user){
        if(models.isEmpty()){
            return 0L;
        }else {
            for (M model:models) {
                this.preDelete(model,user);
            }
            Long deletedCount = this.repository.delete(models.stream().map(M::getId).collect(Collectors.toList()), user);
            if (models.size() != deletedCount) {
//                this.LOGGER.warn("deleting with criteria, expect delete {} item(s), but {} deleted.", models.size(), deletedCount);
            }

            return deletedCount;
        }


    }

    public void preDelete(M model, BaseUser user) {

    }


    // save
    @Transactional
    public M save(V viewModel, BaseUser user){
        Assert.notNull(viewModel,"model can not be null");
        Assert.isNull(viewModel.getId(),"model id in save must be null");
        this.preSave(viewModel,user);
        return repository.save(this.viewToModel(viewModel),user);
    }

    @Transactional
    public List<M> save(List<V> viewModels,BaseUser user){
        Assert.notEmpty(viewModels,"viewModel can not be empty or null");
        if(null!=viewModels && viewModels.size()>0){
            for (V viewModel : viewModels) {
                this.preSave(viewModel,user);
            }
            List<M> modelList = new ArrayList<>();
            for (V viewModel : viewModels) {
                modelList.add(this.viewToModel(viewModel));
            }
            List<M> models = repository.save(modelList,user);
            if (models.size() != modelList.size()) {
                throw new IllegalStateException("invalid save operation, save " + modelList.size() + " model, but result size is " + models.size());
            } else {
                return models;
            }

        }else {
            return new ArrayList<>();
        }
    }

    public void preSave(V viewModel, BaseUser user) {

    }


    // update

    @Transactional
    public M update(V viewModel, BaseUser user) {
        M model = this.repository.get(viewModel.getId());
        this.preUpdate(viewModel, model, user);
        return this.repository.update(this.viewToExistModel(viewModel,model), user);
    }

    public void preUpdate(V viewModel , M previousModel, BaseUser user) {

    }

    // filter
    public DataTableModel<M> filter(C criteria, BaseUser user){
        this.preFilter(criteria,user);
        Long count = this.repository.getFilterCount(criteria);
        if(count <= 0L){
            return new DataTableModel(new ArrayList<>(),count);
        }else {
            DataTableModel<M> dataTableModel = new DataTableModel(this.repository.filter(criteria), count);
            return dataTableModel;
        }
    }

    public void preFilter(C criteria, BaseUser user) {
    }

    // count
    public Long getCount(C criteria){return this.repository.getCount(criteria);}

    public Long getFilterCount(C criteria){return this.repository.getFilterCount(criteria);}


    public Boolean isExist(C criteria){return this.repository.isExist(criteria);}

    public Boolean isNotExist(C criteria){return this.repository.isNotExist(criteria);}

}
