package com.github.emilg1101.lansedeniao.data.base;

public interface TwoWayMapper<F, T> {

    T mapTo(F from);

    F mapFrom(T from);
}
