package com.example.devicedataconsumer.domain.model.converter;

public interface GenericConverter<S,T> {

    T convert(S source);
}
