package com.qinshou.qinshoubox.me.bean;

import com.contrarywind.interfaces.IPickerViewData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/11/8
 */
public class ProvinceBean implements IPickerViewData{
    @SerializedName("province")
    private String name;
    @SerializedName("city")
    private List<CityBean> cityList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityBean> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityBean> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "ProvinceBean{" +
                "name='" + name + '\'' +
                ", cityList=" + cityList +
                '}';
    }

    @Override
    public String getPickerViewText() {
        return this.name;
    }
}
