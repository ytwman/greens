package com.ytwman.greens.manager.model.result;

import com.ytwman.greens.commons.entity.UserInfoEntity;

import java.io.Serializable;

/**
 * Created by ytwman on 16/12/20.
 */
public class UserInfoResult extends UserInfoEntity implements Serializable {

    private String provinceName;
    private String cityName;
    private String districtName;
    private String streetName;
    private String communityName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
