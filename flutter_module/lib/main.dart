import 'package:flutter/material.dart';
import 'dart:ui';
import 'package:http/http.dart';

import 'package:flutter_module/WeatherBean.dart';

void main() {
//  什么是主轴:direction的方向为主轴，与主轴垂直方向为交错轴
  runApp(widgetForRoute(window.defaultRouteName));
}

Widget widgetForRoute(String route) {
  String url =
      "http://apicloud.mob.com/v1/weather/query?key=248dc56241a12&province=北京&city=朝阳";
  print(getData(url));

  WeatherBean weatherBean = new WeatherBean();
  weatherBean.airCondition = "优";
  weatherBean.city = "朝阳";
  weatherBean.coldIndex = "多发期";
  weatherBean.updateTime = "2018-12-29 09:36:05";
  weatherBean.date = "2018-12-29";
  weatherBean.district = "朝阳";
  weatherBean.dressingIndex = "棉衣类";
  weatherBean.humidity = "15%";
  weatherBean.pollutionIndex = 10;
  weatherBean.province = "北京";
  weatherBean.sunset = "18:04";
  weatherBean.sunrise = "06:06";
  weatherBean.temperature = "-10℃";
  weatherBean.time = "09:36:05";
  weatherBean.washIndex = "非常适宜";
  weatherBean.weather = "晴";
  weatherBean.week = "星期六";
  weatherBean.wind = "西北风2级";
  weatherBean.exerciseIndex = "不适宜";
  weatherBean.dayTime = "晴";
  weatherBean.night = "晴";
  weatherBean.future = [];
  switch (route) {
    case "WeatherView":
      return WeatherView(weatherBean);
  }
}

class WeatherView extends StatefulWidget {
  WeatherBean weatherBean;

  WeatherView(this.weatherBean);

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return WeatherState(weatherBean);
  }
}

class WeatherState extends State<WeatherView> {
  WeatherBean weatherBean;

  WeatherState(this.weatherBean);

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
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
          child: Stack(
            children: <Widget>[
              //头部选择城市按钮、城市名称、分享按钮
              Positioned(
                //Row 嵌套在 Positioned 中需要指定宽度
                width: MediaQueryData.fromWindow(window).size.width - 30,
                top: MediaQueryData.fromWindow(window).padding.top,
                child: Row(
                  children: <Widget>[
                    IconButton(
                      icon: Icon(Icons.location_city),
                      color: Color(0xFFFFFFFF),
                      onPressed: () {
                        print("选择城市");
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
                      style: TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
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
                      style: TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                    ),
                    Text(
                      "日落时间：" + weatherBean.sunset,
                      style: TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
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
                      style: TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                    ),
                    Text(
                      "感冒指数：" + weatherBean.coldIndex,
                      style: TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                    ),
                    Text(
                      "运动指数：" + weatherBean.exerciseIndex,
                      style: TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                    ),
                    Text(
                      "洗车指数：" + weatherBean.washIndex,
                      style: TextStyle(fontSize: 15, color: Color(0xFFFFFFFF)),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

Future<String> getData(String url) async {
  try {
    Client client = new Client();
    final response = await client.get(url);
    if (response.statusCode == 200) {
      return response.body;
    }
  } catch (e) {
    print(e);
  }
  return null;
}
