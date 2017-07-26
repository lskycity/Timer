package com.lskycity.timer;

import java.util.Locale;

/**
 * Created by zhaofliu on 7/25/17.
 */

public class Millis {
    public final long millis;

    public Millis(long millis) {
        this.millis = millis;
    }

    @Override
    public String toString() {
        long minus = millis/1000/60 % 60;
        long second = millis/1000 % 60;
        return String.format(Locale.getDefault(), "%02d:%02d", minus, second);
    }
}
