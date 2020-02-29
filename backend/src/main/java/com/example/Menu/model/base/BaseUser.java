package com.example.Menu.model.base;


import com.example.Menu.enums.Status;
import lombok.Getter;
import lombok.Setter;


/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
@Getter
@Setter
public class BaseUser extends BaseModel<Long>{
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Status status;
}
