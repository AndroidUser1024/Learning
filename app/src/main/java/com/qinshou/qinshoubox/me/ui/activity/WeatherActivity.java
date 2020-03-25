package com.qinshou.qinshoubox.me.ui.activity;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.WeatherBean;


/**
 * Description:天气界面
 * Created by 禽兽先生
 * Created on 2018/11/8
 */
public class WeatherActivity extends AppCompatActivity {
    private WeatherBean mWeatherBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        queryWeather();
    }

    private void queryWeather() {
        String ip = SystemUtil.getIPAddress(this);
    }
//    @Override
//    public void setListener() {
//        ibChooseCity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                showCityPickerView();
//            }
//        });
//        ibShare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                ShareUtil.showShare(getContext());
//            }
//        });
//    }
//
//    @Override
//    public void initData() {
//        String ip = SystemUtil.getIPAddress(getActivity());
//        MobApi.getInstance().queryWeather(ip, new BaseObserver<List<WeatherBean>>() {
//            @Override
//            public void onNext(List<WeatherBean> value) {
//                if (value.size() > 0) {
////                    updateUI(value.get(0));
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                queryWeather(null, SharedPreferencesUtil.getString(getContext(), IConstant.LAST_CHOOSE_CITY));
////                ShowLogUtil.logi("ip--->" + e.getMessage());
//            }
//        });
//        MobApi.getInstance().queryCityList(new BaseObserver<List<ProvinceBean>>() {
//            @Override
//            public void onNext(List<ProvinceBean> value) {
//                provinceList.clear();
//                cityList.clear();
//                districtList.clear();
//
//                provinceList = value;
//                for (ProvinceBean provinceBean : value) {
//                    cityList.add(provinceBean.getCityList());
//                    List<List<DistrictBean>> list = new ArrayList<>();
//                    for (CityBean cityBean : provinceBean.getCityList()) {
//                        list.add(cityBean.getDistrictList());
//                    }
//                    districtList.add(list);
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                ShowLogUtil.logi(e.getMessage());
//            }
//        });
//    }
//
/**
 * Description:显示城市选择框
 * Date:2018/11/13
 */
//    private void showCityPickerView() {
//        OptionsPickerView pvOptions = new OptionsPickerBuilder(getContext(), new OnOptionsSelectListener() {
//            @Override
//            public void onOptionsSelect(int options1, int options2, int options3, View v) {
//                //返回的分别是三个级别的选中位置
//                String string = provinceList.get(options1).getName()
//                        + cityList.get(options1).get(options2).getName()
//                        + districtList.get(options1).get(options2).get(options3).getName();
//                queryWeather(provinceList.get(options1).getName(), districtList.get(options1).get(options2).get(options3).getName());
//            }
//        }).setDecorView(rootView)
//                .build();
//        pvOptions.setPicker(provinceList, cityList, districtList);
//        pvOptions.show();
//    }

//    private void updateUI(WeatherBean weatherBean) {
//        mWeatherBean = weatherBean;
//        SharedPreferencesUtil.putString(getContext(), IConstant.LAST_CHOOSE_CITY, weatherBean.getCity());
//        rootView.setBackgroundResource(getBackground(weatherBean.getWeather()));
//        tvCity.setText(weatherBean.getCity());
//        tvTemperature.setText(weatherBean.getTemperature());
//        tvWeather.setText("天气：" + weatherBean.getWeather());
//        StringBuilder updateTime = new StringBuilder();
//        updateTime.append(weatherBean.getUpdateTime().substring(0, 4))
//                .append("-")
//                .append(weatherBean.getUpdateTime().substring(4, 6))
//                .append("-")
//                .append(weatherBean.getUpdateTime().substring(6, 8))
//                .append(" ")
//                .append(weatherBean.getUpdateTime().substring(8, 10))
//                .append(":")
//                .append(weatherBean.getUpdateTime().substring(10, 12))
//                .append(":")
//                .append(weatherBean.getUpdateTime().substring(12, weatherBean.getUpdateTime().length()));
//        tvUpdateTime.setText(updateTime.toString());
//        tvWeek.setText(weatherBean.getWeek());
//        ivAirCondition.setImageResource(getAirConditionIvSrc(weatherBean.getPollutionIndex()));
//        tvAirCondition.setText("空气指数：" + weatherBean.getAirCondition());
//        tvWind.setText("风向：" + weatherBean.getWind());
//        tvHumidity.setText(weatherBean.getHumidity());
//        tvSunrise.setText("日出时间：" + weatherBean.getSunrise());
//        tvSunset.setText("日落时间：" + weatherBean.getSunset());
//        tvWashIndex.setText("洗车指数：" + weatherBean.getWashIndex());
//        tvExerciseIndex.setText("运动指数：" + weatherBean.getExerciseIndex());
//        tvColdIndex.setText("感冒指数：" + weatherBean.getColdIndex());
//        tvDressingIndex.setText("穿衣指数：" + weatherBean.getDressingIndex());
//    }

    /**
     * author：MrQinshou
     * Description:根据空气指数得到对应图片
     * date:2018/11/13 21:04
     * param
     * return
     */
//    private int getAirConditionIvSrc(int pollutionIndex) {
//        if (pollutionIndex > 300) {
//            return R.drawable.weather_air_condition_iv_src_7;
//        } else if (pollutionIndex > 250) {
//            return R.drawable.weather_air_condition_iv_src_6;
//        } else if (pollutionIndex > 200) {
//            return R.drawable.weather_air_condition_iv_src_5;
//        } else if (pollutionIndex > 150) {
//            return R.drawable.weather_air_condition_iv_src_4;
//        } else if (pollutionIndex > 100) {
//            return R.drawable.weather_air_condition_iv_src_3;
//        } else if (pollutionIndex > 50) {
//            return R.drawable.weather_air_condition_iv_src_2;
//        } else {
//            return R.drawable.weather_air_condition_iv_src_1;
//        }
//    }

    /**
     * author：MrQinshou
     * Description:根据天气得到对应背景
     * date:2018/11/13 21:04
     * param
     * return
     */
//    private int getBackground(String weather) {
//        //获得当前时间
//        int currentHour = Integer.parseInt(new SimpleDateFormat("HH", Locale.CHINA).format(new Date(System.currentTimeMillis())));
//        if (weather.contains("晴")) {
//            if (currentHour >= 6 && currentHour < 18) {
//                return R.drawable.weather_bg_sunny_day;
//            } else {
//                return R.drawable.weather_bg_sunny_night;
//            }
//        } else if (weather.contains("雨")) {
//            if (currentHour >= 6 && currentHour < 18) {
//                return R.drawable.weather_bg_rain_day;
//            } else {
//                return R.drawable.weather_bg_rain_night;
//            }
//        } else if (weather.contains("雪")) {
//            if (currentHour >= 6 && currentHour < 18) {
//                return R.drawable.weather_bg_snow_day;
//            } else {
//                return R.drawable.weather_bg_snow_night;
//            }
//        } else if (weather.contains("阴")) {
//            if (currentHour >= 6 && currentHour < 18) {
//                return R.drawable.weather_bg_overcast_day;
//            } else {
//                return R.drawable.weather_bg_overcast_night;
//            }
//        } else if (weather.contains("雾")) {
//            if (currentHour >= 6 && currentHour < 18) {
//                return R.drawable.weather_bg_fog_day;
//            } else {
//                return R.drawable.weather_bg_fog_night;
//            }
//        } else if (weather.contains("霾")) {
//            return R.drawable.weather_bg_fog_and_haze;
//        }
//        // N/A,not available
//        return R.drawable.weather_bg_na;
//    }

//    private void showFuture(WeatherBean weatherBean) {
//        if (weatherBean == null) {
//            return;
//        }
//        List<Label> xLabelList = new ArrayList<>();
//        List<Label> yLabelList = new ArrayList<>();
//        List<Integer> highestList = new ArrayList<>();
//        List<Integer> lowestList = new ArrayList<>();
//        List<String> dayTimeWeatherList = new ArrayList<>();
//        for (int i = 0; i < weatherBean.getFuture().size(); i++) {
//            dayTimeWeatherList.add(weatherBean.getFuture().get(i).getDayTime());
//            String temperature = weatherBean.getFuture().get(i).getTemperature();
//            String[] temperatureArray = temperature.split("/");
//            if (temperatureArray.length > 1) {
//                highestList.add(Integer.valueOf(temperatureArray[0].trim().replace("°C", "")));
//                lowestList.add(Integer.valueOf(temperatureArray[1].trim().replace("°C", "")));
//            } else if (temperatureArray.length > 0) {
//                highestList.add(Integer.valueOf(temperatureArray[0].trim().replace("°C", "")));
//                lowestList.add(Integer.valueOf(temperatureArray[0].trim().replace("°C", "")));
//            } else {
//                highestList.add(0);
//                lowestList.add(0);
//            }
//            xLabelList.add(new Label(weatherBean.getFuture().get(i).getWeek()));
//        }
//        ShowLogUtil.logi(xLabelList);
//        ShowLogUtil.logi(highestList);
//        ShowLogUtil.logi(lowestList);
//        ShowLogUtil.logi(dayTimeWeatherList);
//        View view = new DialogUtil.Builder(getContext())
//                .setView(R.layout.ppw_weather_future)
//                .create()
//                .showCustomDialog();
//
////        RecyclerView rvFuture = view.findViewById(R.id.rv_future);
//        MultipleLineChartView multipleLineChartView = view.findViewById(R.id.multiple_line_chart_view);
//        LineList lineList = new LineList();
//        DataLine highestLine = new DataLine();
//        highestLine.setType(DataLine.Type.BEZIER);
//        for (int i = 0; i < highestList.size(); i++) {
//            highestLine.addPoint(new DataPoint(i, highestList.get(i)));
//        }
//        lineList.addLine(highestLine);
//
//        DataLine lowestLine = new DataLine();
//        lowestLine.setType(DataLine.Type.BEZIER);
//        for (int i = 0; i < lowestList.size(); i++) {
//            lowestLine.addPoint(new DataPoint(i, lowestList.get(i)));
//        }
//        lineList.addLine(lowestLine);
//
//        multipleLineChartView.setAnimateDraw(true);
//        multipleLineChartView.getXAxis().setLabelList(xLabelList);
//        for (int i = Collections.max(highestList); i > Collections.min(lowestList) ; i--) {
//            yLabelList.add(new Label(i + "°C"));
//        }
//        multipleLineChartView.getYAxis().setLabelList(yLabelList);
//        multipleLineChartView.setLineList(lineList);
//        multipleLineChartView.setMax(Collections.max(highestList) + 1);
//        multipleLineChartView.setMin(Collections.min(lowestList) - 1);
//    }
}
