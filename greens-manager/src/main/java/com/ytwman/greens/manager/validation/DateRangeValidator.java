/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/18 下午5:56
 * Description: 
 */
package com.ytwman.greens.manager.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateRangeValidator implements ConstraintValidator<DateRange, Date> {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final String now = "now";

    private Date min;
    private Date max;

    @Override
    public void initialize(DateRange constraintAnnotation) {
        if (now.equals(constraintAnnotation.max())) {
            max = new Date();
        }

        try {
            min = sdf.parse(constraintAnnotation.min());
        } catch (ParseException e) {
            e.printStackTrace();
            min = null;
        }
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (min == null || value == null) {
            return false;
        }

        return value.before(max) && value.after(min);
    }
}
