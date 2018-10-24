package com.lh.lhzkc.exception;

public class ClientRuntimeException extends RuntimeException {
    String errCode;
    String errMessage;

    public String getErrMessage() {
        return errMessage;
    }

    public ClientRuntimeException(String errCode, String errMessage) {
        super(String.format("%s: %s", errCode, errMessage));
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    @Override
    public String toString() {
        return String.format(errMessage);
    }


}
