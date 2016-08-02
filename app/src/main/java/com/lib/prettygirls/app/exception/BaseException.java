package com.lib.prettygirls.app.exception;

/**
 * Created by weijinqian on 16/7/31.
 */
public class BaseException extends RuntimeException {
    public static final long serialVersionId=1L;

    public BaseException() {
    }

    public BaseException(String detailMessage) {
        super(detailMessage);
    }

    public BaseException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }
}
