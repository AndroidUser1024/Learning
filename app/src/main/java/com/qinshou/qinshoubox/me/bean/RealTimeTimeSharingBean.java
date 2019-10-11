package com.qinshou.qinshoubox.me.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:股票实时分时实体类
 * Author: QinHao
 * Date: 2019/3/23 9:45
 */
public class RealTimeTimeSharingBean {
    @SerializedName("code")
    private String code;    //股票代码
    @SerializedName("market")
    private String market;  //所属交易所
    @SerializedName("name")
    private String name;  //股票名字
    @SerializedName("ret_code")
    private String retCode;  //请求结果码
    @SerializedName("dataList")
    private List<DataBean> mDataBeanList;

    public RealTimeTimeSharingBean() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<DataBean> getDataBeanList() {
        return mDataBeanList;
    }

    public void setDataBeanList(List<DataBean> dataBeanList) {
        mDataBeanList = dataBeanList;
    }

    @Override
    public String toString() {
        return "RealTimeTimeSharingBean{" +
                "code='" + code + '\'' +
                ", market='" + market + '\'' +
                ", name='" + name + '\'' +
                ", retCode='" + retCode + '\'' +
                ", mDataBeanList=" + mDataBeanList +
                '}';
    }

    //分时数据列表实体类
    public static class DataBean {
        @SerializedName("count")
        private int count;  //总条目数
        @SerializedName("date")
        private String date;  //日期
        @SerializedName("yestclose")
        private float yesterdayClose;  //昨日收盘价
        @SerializedName("lastVolume")
        private String lastVolume;  //最终成交量
        @SerializedName("minuteList")
        private List<MinuteBean> mMinuteBeanList;  //分时数据列表

        public DataBean() {
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public float getYesterdayClose() {
            return yesterdayClose;
        }

        public void setYesterdayClose(float yesterdayClose) {
            this.yesterdayClose = yesterdayClose;
        }

        public String getLastVolume() {
            return lastVolume;
        }

        public void setLastVolume(String lastVolume) {
            this.lastVolume = lastVolume;
        }

        public List<MinuteBean> getMinuteBeanList() {
            return mMinuteBeanList;
        }

        public void setMinuteBeanList(List<MinuteBean> minuteBeanList) {
            mMinuteBeanList = minuteBeanList;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", date='" + date + '\'' +
                    ", yesterdayClose='" + yesterdayClose + '\'' +
                    ", lastVolume='" + lastVolume + '\'' +
                    ", mMinuteBeanList=" + mMinuteBeanList +
                    '}';
        }
    }

    //分时数据每一个点对应实体类
    public static class MinuteBean {
        @SerializedName("time")
        private String time;    //时间
        @SerializedName("nowPrice")
        private float nowPrice;    //现价
        @SerializedName("volume")
        private String volume;    //成交量
        @SerializedName("avgPrice")
        private float avgPrice;    //均价

        public MinuteBean() {
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public float getNowPrice() {
            return nowPrice;
        }

        public void setNowPrice(float nowPrice) {
            this.nowPrice = nowPrice;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public float getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(float avgPrice) {
            this.avgPrice = avgPrice;
        }

        @Override
        public String toString() {
            return "MinuteBean{" +
                    "time='" + time + '\'' +
                    ", nowPrice='" + nowPrice + '\'' +
                    ", volume='" + volume + '\'' +
                    ", avgPrice='" + avgPrice + '\'' +
                    '}';
        }
    }

}
