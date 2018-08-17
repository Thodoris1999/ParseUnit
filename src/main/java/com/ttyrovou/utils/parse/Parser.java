package com.ttyrovou.utils.parse;

public interface Parser<T, U> {
    U parse(T t);
}
