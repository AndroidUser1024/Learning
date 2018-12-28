package com.qinshou.qinshoubox.me.bean;

import com.contrarywind.interfaces.IPickerViewData;
import com.google.gson.annotations.SerializedName;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/11/8
 */
public class DistrictBean implements IPickerViewData {
    @SerializedName("district")
    private String name;

    public DistrictBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DistrictBean{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getPickerViewText() {
        return this.name;
    }
}
