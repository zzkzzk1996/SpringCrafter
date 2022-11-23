package com.learning.springframework.beans;

/**
 * @author zekunzhang
 * @version 1.0.0
 * @Class BeansException.java
 * @Desc exception class for beans
 * @date 2022/11/23 22:31
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
