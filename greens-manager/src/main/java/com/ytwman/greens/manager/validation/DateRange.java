/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/18 下午5:48
 * Description: 
 */
package com.ytwman.greens.manager.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Past;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface DateRange {

    // 时间最小值
    String min();

    // 时间最大值, 默认当前时间
    String max() default "now";

    String message() default "时间参数错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@link Past} annotations on the same element.
     *
     * @see Past
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Past[] value();
    }

}
