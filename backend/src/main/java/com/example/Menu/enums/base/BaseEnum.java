package com.example.Menu.enums.base;

import java.util.Arrays;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/

public interface BaseEnum<C> {
    String getTitle();
    C getValue();

    default Boolean isContains(BaseEnum... enums){
        return Arrays.asList(enums).contains(this);
    }

    default Boolean isNotContains(BaseEnum... enums){
        return !this.isContains(this);
    }

}
