package com.ytwman.greens.commons.core.web;

import com.ytwman.greens.commons.helper.DateFormatter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ytwman on 16/12/28.
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        Date date = null;

        if (StringUtils.isEmpty(source)) {
            return null;
        }

        try {
            date = new SimpleDateFormat(DateFormatter.FORMAT_DATETIME).parse(source);
        } catch (Exception e) {
            try {
                date = new SimpleDateFormat(DateFormatter.FORMAT_DATE).parse(source);
            } catch (Exception e1) {
                date = new Date(Long.valueOf(source));
            }
        }

        return date;
    }
}
