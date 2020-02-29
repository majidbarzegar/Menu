package com.example.Menu.mapper.base;

import com.example.Menu.model.base.BaseModel;
import com.example.Menu.viewmodel.base.BaseViewModel;
import org.mapstruct.factory.Mappers;

/**
 * @author : Majid Barzegar
 * @date : 2/23/2020
 **/
public interface BaseMapper<M extends BaseModel,V extends BaseViewModel> {
    BaseMapper INSTANCE = Mappers.getMapper(BaseMapper.class);

    M viewToModel(V baseViewModel);

    V modelToView(M baseModel);
}