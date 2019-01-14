import 'dart:ui';

import 'package:flutter/material.dart';
import 'dart:convert';

import 'package:flutter_module/Http.dart';
import 'package:flutter_module/weather/bean/MobApiResultBean.dart';
import 'package:flutter_module/weather/bean/WeatherBean.dart';
import 'package:flutter_module/weather/widget/WeatherView.dart';

void main() {
  runApp(widgetForRoute(window.defaultRouteName));
//  runApp(widgetForRoute("WeatherView"));
  print("window.defaultRouteName--->"+window.defaultRouteName);
}

Widget widgetForRoute(String route) {
  switch (route) {
    case "WeatherView":
      WeatherView weatherView = WeatherView();
      runApp(weatherView);

      String url =
          "http://apicloud.mob.com/v1/weather/query?key=248dc56241a12&province=北京&city=北京";
      getRequest(url, (String data) {
        MobApiResultBean mobApiResultBean =
        MobApiResultBean.fromJson(json.decode(data));
        WeatherBean weatherBean = WeatherBean.fromJson(
            json.decode(json.encode(mobApiResultBean.result.elementAt(0))));
        weatherView.weatherState.setWeatherBean(weatherBean);
      }, (int errorCode) {
        print(errorCode);
      });
      return weatherView;
  }
}
