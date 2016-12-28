package com.ytwman.greens.commons.core.web;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Created by ytwman on 16/12/28.
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        return source == null || source.isEmpty() ? null : new Date(Long.valueOf(source));
    }
}
