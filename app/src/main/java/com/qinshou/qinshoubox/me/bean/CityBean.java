package com.qinshou.qinshoubox.me.bean;

import com.contrarywind.interfaces.IPickerViewData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/11/8
 */
public class CityBean implements IPickerViewData {
    @SerializedName("city")
    private String name;
    @SerializedName("district")
    private List<DistrictBean> districtList;

    public CityBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DistrictBean> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<DistrictBean> districtList) {
        this.districtList = districtList;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "name='" + name + '\'' +
                ", districtList=" + districtList +
                '}';
    }

    @Override
    public String getPickerViewText() {
        return this.name;
    }
}
