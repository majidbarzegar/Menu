package com.example.Menu.viewmodel.base;

import com.example.Menu.model.base.BaseUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
@Getter
@Setter
public abstract class BaseViewModel<I extends Comparable<I>> {
    private I id;
    private BaseUser createBy;
    private BaseUser updateBy;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
