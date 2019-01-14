import 'package:flutter/material.dart';
import 'dart:ui';
import 'dart:convert';

import 'package:flutter_picker/flutter_picker.dart';

import 'package:flutter_module/FileLoadUtil.dart';
import 'package:flutter_module/weather/bean/WeatherBean.dart';
import 'package:flutter_module/Http.dart';
import 'package:flutter_module/weather/bean/MobApiResultBean.dart';

class WeatherView extends StatefulWidget {
  WeatherState weatherState = WeatherState();

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return weatherState;
  }
}

class WeatherState extends State<WeatherView> {
  WeatherBean weatherBean;
  String provinceListJson;

  WeatherState();

  @override
  Widget build(BuildContext context) {
    loadAssetsFile(context, "assets/json/cityList.json", (String result) {
      provinceListJson = result;
    }, (String errorInfo) {});
    // TODO: implement build
    if (weatherBean == null) {
      return MaterialApp(
        title: "WeatherView",
        debugShowCheckedModeBanner: false,
        home: Scaffold(
          body: Container(
            padding: EdgeInsets.all(15),
            decoration: BoxDecoration(
              image: DecorationImage(
                  fit: BoxFit.fill,
                  image: AssetImage("assets/images/weather_bg_sunny_day.jpg")),
            ),
          ),
        ),
      );
    }
    return MaterialApp(
      title: "WeatherView",
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: Container(
          padding: EdgeInsets.all(15),
          decoration: BoxDecoration(
            image: DecorationImage(
                fit: BoxFit.fill,
                image: AssetImage("assets/images/weather_bg_sunny_day.jpg")),
          ),
          child: Builder(builder: (BuildContext context) {
            //showCityPicker() 方法中弹出一个 BottomSheet，所以写成 Builder(){} 这样。。。具体原因嘛。。。
            return Stack(
              children: <Widget>[
                //头部选择城市按钮、城市名称、分享按钮
                Positioned(
                  //Row 嵌套在 Positioned 中需要指定宽度
                  //30 为左右 padding 的和
                  width: MediaQueryData.fromWindow(window).size.width - 30,
                  top: MediaQueryData.fromWindow(window).padding.top,
                  child: Row(
                    children: <Widget>[
                      IconButton(
                        icon: Icon(Icons.location_city),
                        color: Color(0xFFFFFFFF),
                        onPressed: () {
                          showCityPicker(context, provinceListJson);
                        },
                      ),
                      Expanded(
                        child: Container(
                          alignment: Alignment.center,
                          child: Text(
                            weatherBean.city,
                            style: TextStyle(
                              fontSize: 20,
                              color: Color(0xFFFFFFFF),
                            ),
                          ),
                        ),
                      ),
                      IconButton(
                        icon: Icon(Icons.share),
                        color: Color(0xFFFFFFFF),
                        onPressed: () {
                          print("分享");
                        },
                      ),
                    ],
                  ),
                ),
                //左上温度、天气
                Positioned(
                  left: 0,
                  top: 150,
                  child: Wrap(
                    direction: Axis.vertical,
                    children: <Widget>[
                      Text(
                        weatherBean.temperature,
                        style: TextStyle(
                          fontSize: 80,
                          color: Color(0xFFFFFFFF),
                        ),
                      ),
                      Text(
                        "天气：" + weatherBean.weather,
                        style: TextStyle(
                          fontSize: 20,
                          color: Color(0xFFFFFFFF),
                        ),
                      ),
                    ],
                  ),
                ),
                //右上空气指数、湿度、风向、更新时间
                Positioned(
                  right: 0,
                  top: 120,
                  child: Wrap(
                    direction: Axis.vertical,
                    spacing: 20,
                    crossAxisAlignment: WrapCrossAlignment.end,
                    children: <Widget>[
                      Text(
                        "空气指数：" + weatherBean.airCondition,
                        style:
                            TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                      ),
                      Text(
                        "湿度：" + weatherBean.humidity,
                        style: TextStyle(
                          fontSize: 15,
                          color: Color(0xFFFFFFFF),
                        ),
                      ),
                      Text(
                        "风向：" + weatherBean.wind,
                        style: TextStyle(
                          fontSize: 15,
                          color: Color(0xFFFFFFFF),
                        ),
                      ),
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.end,
                        children: <Widget>[
                          Text(
                            "更新时间",
                            style: TextStyle(
                              fontSize: 15,
                              color: Color(0xFFFFFFFF),
                            ),
                            textAlign: TextAlign.end,
                          ),
                          Text(
                            weatherBean.updateTime,
                            style: TextStyle(
                              fontSize: 15,
                              color: Color(0xFFFFFFFF),
                            ),
                            textAlign: TextAlign.end,
                          ),
                        ],
                      )
                    ],
                  ),
                ),
                Positioned(
                  bottom: 0,
                  child: Wrap(
                    direction: Axis.vertical,
                    spacing: 10,
                    children: <Widget>[
                      Text(
                        "日出时间：" + weatherBean.sunrise,
                        style:
                            TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                      ),
                      Text(
                        "日落时间：" + weatherBean.sunset,
                        style:
                            TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                      ),
                    ],
                  ),
                ),
                Positioned(
                  bottom: 0,
                  right: 0,
                  child: Wrap(
                    crossAxisAlignment: WrapCrossAlignment.end,
                    direction: Axis.vertical,
                    spacing: 10,
                    children: <Widget>[
                      Text(
                        "穿衣指数：" + weatherBean.dressingIndex,
                        style:
                            TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                      ),
                      Text(
                        "感冒指数：" + weatherBean.coldIndex,
                        style:
                            TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                      ),
                      Text(
                        "运动指数：" + weatherBean.exerciseIndex,
                        style:
                            TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                      ),
                      Text(
                        "洗车指数：" + weatherBean.washIndex,
                        style:
                            TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                      ),
                    ],
                  ),
                ),
              ],
            );
          }),
        ),
      ),
    );
  }

  void setWeatherBean(WeatherBean weatherBean) {
    setState(() {
      this.weatherBean = weatherBean;
    });
  }

  void showCityPicker(BuildContext buildContext, String provinceListJson) {
    new Picker(
        adapter: PickerDataAdapter<String>(
            pickerdata: new JsonDecoder().convert(provinceListJson)),
        changeToFirst: true,
        hideHeader: false,
        confirmText: "确定",
        cancelText: "取消",
        onConfirm: (Picker picker, List value) {
          String selectedProvince = picker.getSelectedValues().elementAt(0);
          String selectedDistrict = picker.getSelectedValues().elementAt(2);
          String url =
              "http://apicloud.mob.com/v1/weather/query?key=248dc56241a12&province=" +
                  selectedProvince +
                  "&city=" +
                  selectedDistrict;
          getRequest(url, (String data) {
            MobApiResultBean mobApiResultBean =
                MobApiResultBean.fromJson(json.decode(data));
            WeatherBean weatherBean = WeatherBean.fromJson(
                json.decode(json.encode(mobApiResultBean.result.elementAt(0))));
            print(weatherBean);
            setWeatherBean(weatherBean);
          }, (int errorCode) {
            print(errorCode);
          });
        }).showModal(buildContext); //_scaffoldKey.currentState);
  }
}
