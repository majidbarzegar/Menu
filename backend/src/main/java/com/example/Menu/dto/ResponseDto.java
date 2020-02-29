package com.example.Menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : Majid Barzegar
 * @date : 2/29/2020
 **/

@Getter
@Setter
public class ResponseDto<R> implements Serializable {

    public ResponseDto() {
    }

    public ResponseDto(R response) {
        this.response = response;
    }

    public ResponseDto(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public ResponseDto(byte reactionCode, String text) {
        this.reactionCode = reactionCode;
        this.text = text;
    }

    public ResponseDto(byte reactionCode, int code, String text) {
        this.reactionCode = reactionCode;
        this.code = code;
        this.text = text;
    }

    public ResponseDto(R response, byte reactionCode, int code, String text) {
        this(reactionCode, code, text);
        this.response = response;
    }

    public ResponseDto(R response, byte reactionCode, String text) {
        this(reactionCode, text);
        this.response = response;
    }

    private R response;
    private Object config;
    private Byte reactionCode;
    private Integer code;
    private String text;
    private String uuid;

    public boolean hasMessage() {
        return null != this.text;
    }

}
