package com.qinshou.qinshoubox.me.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:天气实体类
 * Created by 禽兽先生
 * Created on 2018/11/13
 */
public class WeatherBean extends BaseObservable {
    @SerializedName("airCondition")
    private String airCondition;    //空气质量
    @SerializedName("city")
    @Bindable
    private String city;    //城市
    @SerializedName("coldIndex")
    private String coldIndex;   //感冒指数
    @SerializedName("updateTime")
    private String updateTime;  //更新时间的时间戳
    @SerializedName("date")
    private String date;    //日期
    @SerializedName("distrct")
    private String distrct; //区县
    @SerializedName("dressingIndex")
    private String dressingIndex;   //穿衣指数
    @SerializedName("humidity")
    private String humidity;   //湿度
    @SerializedName("pollutionIndex")
    private int pollutionIndex;   //空气质量指数
    @SerializedName("province")
    private String province;   //省份
    @SerializedName("sunset")
    private String sunset;   //日落时间
    @SerializedName("sunrise")
    private String sunrise;   //日出时间
    @SerializedName("temperature")
    private String temperature;   //温度
    @SerializedName("time")
    private String time;   //时间
    @SerializedName("washIndex")
    private String washIndex;   //洗车指数
    @SerializedName("weather")
    private String weather;   //天气
    @SerializedName("week")
    private String week;   //星期几
    @SerializedName("wind")
    private String wind;   //风向
    @SerializedName("exerciseIndex")
    private String exerciseIndex;   //运动指数
    @SerializedName("dayTime")
    private String dayTime;   //白天天气
    @SerializedName("night")
    private String night;   //晚上天气
    @SerializedName("future")
    private List<WeatherBean> future;   //未来一周的天气

    public WeatherBean() {
    }


    public String getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getColdIndex() {
        return coldIndex;
    }

    public void setColdIndex(String coldIndex) {
        this.coldIndex = coldIndex;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistrct() {
        return distrct;
    }

    public void setDistrct(String distrct) {
        this.distrct = distrct;
    }

    public String getDressingIndex() {
        return dressingIndex;
    }

    public void setDressingIndex(String dressingIndex) {
        this.dressingIndex = dressingIndex;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public int getPollutionIndex() {
        return pollutionIndex;
    }

    public void setPollutionIndex(int pollutionIndex) {
        this.pollutionIndex = pollutionIndex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWashIndex() {
        return washIndex;
    }

    public void setWashIndex(String washIndex) {
        this.washIndex = washIndex;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getExerciseIndex() {
        return exerciseIndex;
    }

    public void setExerciseIndex(String exerciseIndex) {
        this.exerciseIndex = exerciseIndex;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public List<WeatherBean> getFuture() {
        return future;
    }

    public void setFuture(List<WeatherBean> future) {
        this.future = future;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "airCondition='" + airCondition + '\'' +
                ", city='" + city + '\'' +
                ", coldIndex='" + coldIndex + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", date='" + date + '\'' +
                ", distrct='" + distrct + '\'' +
                ", dressingIndex='" + dressingIndex + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pollutionIndex='" + pollutionIndex + '\'' +
                ", province='" + province + '\'' +
                ", sunset='" + sunset + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", temperature='" + temperature + '\'' +
                ", time='" + time + '\'' +
                ", washIndex='" + washIndex + '\'' +
                ", weather='" + weather + '\'' +
                ", week='" + week + '\'' +
                ", wind='" + wind + '\'' +
                ", exerciseIndex='" + exerciseIndex + '\'' +
                ", dayTime='" + dayTime + '\'' +
                ", night='" + night + '\'' +
                ", future=" + future +
                '}';
    }
}
