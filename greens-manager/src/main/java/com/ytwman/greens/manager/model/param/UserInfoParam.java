/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/18 下午5:38
 * Description: 
 */
package com.ytwman.greens.manager.model.param;

import com.ytwman.greens.commons.entity.UserInfoEntity;
import com.ytwman.greens.manager.validation.DateRange;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserInfoParam extends UserInfoEntity implements Serializable {

    @NotEmpty(message = "未填写名称")
    private String name;

    @DateRange(min = "1920-01-01", message = "日期大于当前时间")
    @NotNull(message = "未填写出生日期")
    private Date birthday;

    @NotNull(message = "未选择省份")
    private Long province;

    @NotNull(message = "未选择城市")
    private Long city;

    @NotNull(message = "未选择县市区")
    private Long district;

    @NotNull(message = "未选择街道（乡镇）")
    private Long street;

    @NotNull(message = "未选择小区")
    private Long community;

    @NotNull(message = "未填写地址")
    private String address;

    @NotNull(message = "未填写手机号码")
    private String phone;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public Long getProvince() {
        return province;
    }

    @Override
    public void setProvince(Long province) {
        this.province = province;
    }

    @Override
    public Long getCity() {
        return city;
    }

    @Override
    public void setCity(Long city) {
        this.city = city;
    }

    @Override
    public Long getDistrict() {
        return district;
    }

    @Override
    public void setDistrict(Long district) {
        this.district = district;
    }

    @Override
    public Long getStreet() {
        return street;
    }

    @Override
    public void setStreet(Long street) {
        this.street = street;
    }

    @Override
    public Long getCommunity() {
        return community;
    }

    @Override
    public void setCommunity(Long community) {
        this.community = community;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
