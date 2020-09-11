package com.bsuir.diploma.diploma.converter;

import com.sun.istack.NotNull;

public interface ObjectConverter<R, T> {
    T parse(@NotNull R resource);
}
