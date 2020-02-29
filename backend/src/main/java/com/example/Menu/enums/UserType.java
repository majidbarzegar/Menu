package com.example.Menu.enums;

import com.example.Menu.enums.base.BaseEnum;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
public enum UserType implements BaseEnum<Byte> {
    CUSTOMER((byte)1,"مشتری"),
    SERVICE_PROVIDER((byte)2,"ارائه دهنده خدمت");

    UserType(Byte value, String title) {
        this.value = value;
        this.title = title;
    }

    private final Byte value;
    private final String title;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Byte getValue() {
        return value;
    }

    public static UserType getByValue(Byte value){
        if(null == value)
            return null;
        for (UserType s : UserType.values()) {
            if(s.value.equals(value))
                return s;
        }
        return null;
    }
}

