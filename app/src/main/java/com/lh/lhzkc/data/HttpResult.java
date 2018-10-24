package com.lh.lhzkc.data;

import com.google.gson.annotations.SerializedName;

public class HttpResult<T> {

    @SerializedName("code")
    public String code;
    @SerializedName("message")
    public String msg;

    @SerializedName("data")
    T data;

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
