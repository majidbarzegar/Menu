package com.example.Menu.controller.base;

import com.example.Menu.criteria.base.BaseCriteria;
import com.example.Menu.dto.ResponseDto;
import com.example.Menu.model.base.BaseModel;
import com.example.Menu.model.base.BaseUser;
import com.example.Menu.model.base.DataTableModel;
import com.example.Menu.service.base.BaseService;
import com.example.Menu.viewmodel.base.BaseViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * @author : Majid Barzegar
 * @date : 2/23/2020
 **/
public abstract class BaseController<M extends BaseModel<I>,C extends BaseCriteria<I>,V extends BaseViewModel<I>,S extends BaseService<M,C,V,I> , I extends Comparable<I>> {

    @Autowired
    private S service;

    @RequestMapping(
            value = {"/save"},
            method = {RequestMethod.POST},
            consumes = {"application/json"}
    )
    public ResponseDto<M> save(@RequestBody V viewModel) throws Exception{
        return new ResponseDto<>(this.service.save(viewModel,getUser()));
    }

    @RequestMapping(
            value ={"/get"},
            method = {RequestMethod.GET}
    )
    public ResponseDto<M> get(@PathVariable I id) throws Exception{
        return new ResponseDto<>(this.service.get(id));
    }

    @RequestMapping(
            value = {"/update"},
            method = {RequestMethod.PUT},
            consumes = {"application/json"}
    )
    public ResponseDto<M> update(@RequestBody V viewModel) throws Exception{
        return new ResponseDto<>(this.service.update(viewModel,getUser()));
    }

    @RequestMapping(
            value ={"/delete"},
            method = {RequestMethod.DELETE}
    )
    public ResponseDto<Long> delete(@PathVariable I id) throws Exception{
        return new ResponseDto<>(this.service.delete(id,getUser()));
    }

    @RequestMapping(
            value = {"list"},
            method = {RequestMethod.POST},
            consumes = {"application/json"}
    )
    public ResponseDto<List<M>> list(@RequestBody C criteria) {
        return new ResponseDto(this.service.getAll(criteria));
    }

    @RequestMapping(
            value = {"filter"},
            method = {RequestMethod.POST},
            consumes = {"application/json"}
    )
    public ResponseDto<DataTableModel<M>> filter(@RequestBody C criteria) {
        return new ResponseDto(this.service.filter(criteria, this.getUser()));
    }

    protected final BaseUser getUser() {
        return new BaseUser();
    }


}



