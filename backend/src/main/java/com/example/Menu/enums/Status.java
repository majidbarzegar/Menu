package com.example.Menu.enums;

import com.example.Menu.enums.base.BaseEnum;

/**
 * @author : Majid Barzegar
 * @date : 2/22/2020
 **/
public enum Status implements BaseEnum<Byte> {
    ACTIVE((byte)1,"فعال"),
    INACTIVE((byte)2,"غیر فعال");

    Status(Byte value, String title) {
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

    public static Status getByValue(Byte value){
        if(null == value)
            return null;
        for (Status s : Status.values()) {
            if(s.value.equals(value))
                return s;
        }
        return null;
    }
}

