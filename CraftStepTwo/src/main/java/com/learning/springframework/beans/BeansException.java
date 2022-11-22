package com.learning.springframework.beans;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class BeansException.java
 * @Desc exception class for beans
 * @date 2022/11/22 22:52
 */
public class BeansException extends RuntimeException {

    public BeansException() {
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeansException(Throwable cause) {
        super(cause);
    }

    public BeansException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
