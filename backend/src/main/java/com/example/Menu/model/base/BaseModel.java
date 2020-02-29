package com.example.Menu.model.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
@Getter
@Setter
public abstract class BaseModel<I extends Comparable<I>> implements Serializable {
    private static final long serialVersionUID = 8032792238223353225L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "sequence")
    private I id;
    private BaseUser createBy;
    private BaseUser updateBy;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
