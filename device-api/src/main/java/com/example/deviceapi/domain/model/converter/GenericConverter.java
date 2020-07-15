package com.example.deviceapi.domain.model.converter;

public interface GenericConverter<S,T> {

    T convert(S source);
}
