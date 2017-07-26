package com.lskycity.timer;

/**
 * Created by liuzhaofeng on 12/24/15.
 */
public class ParentNotImplementListenerException extends RuntimeException {

    public ParentNotImplementListenerException() {
    }

    public ParentNotImplementListenerException(String detailMessage) {
        super(detailMessage);
    }

    public ParentNotImplementListenerException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ParentNotImplementListenerException(Throwable throwable) {
        super(throwable);
    }
}
