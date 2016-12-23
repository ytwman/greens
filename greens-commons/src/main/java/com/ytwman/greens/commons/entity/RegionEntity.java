package com.ytwman.greens.commons.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RegionEntity implements Serializable {
    private Long id;

    private Long parentId;

    private String name;

    private String smallName;

    private String indexChar;

    private String pinyin;

    private String code;

    private String weatherCode;

    private Integer level;

    private String zipcode;

    private String diallingCode;

    private BigDecimal lng;

    private BigDecimal lat;

    private String description;

    private String sortby;

    private Date createdTime;

    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSmallName() {
        return smallName;
    }

    public void setSmallName(String smallName) {
        this.smallName = smallName == null ? null : smallName.trim();
    }

    public String getIndexChar() {
        return indexChar;
    }

    public void setIndexChar(String indexChar) {
        this.indexChar = indexChar == null ? null : indexChar.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode == null ? null : weatherCode.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getDiallingCode() {
        return diallingCode;
    }

    public void setDiallingCode(String diallingCode) {
        this.diallingCode = diallingCode == null ? null : diallingCode.trim();
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSortby() {
        return sortby;
    }

    public void setSortby(String sortby) {
        this.sortby = sortby == null ? null : sortby.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", smallName=").append(smallName);
        sb.append(", indexChar=").append(indexChar);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", code=").append(code);
        sb.append(", weatherCode=").append(weatherCode);
        sb.append(", level=").append(level);
        sb.append(", zipcode=").append(zipcode);
        sb.append(", diallingCode=").append(diallingCode);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", description=").append(description);
        sb.append(", sortby=").append(sortby);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}