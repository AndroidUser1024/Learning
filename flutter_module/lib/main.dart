import 'package:flutter/material.dart';
import 'package:flutter_module/weather/MobApiResultBean.dart';
import 'package:flutter_module/weather/WeatherView.dart';
import 'dart:ui';
import 'package:http/http.dart';

import 'package:flutter_module/weather/WeatherBean.dart';

void main() {
  WeatherView weatherView = WeatherView();
  runApp(weatherView);

  String url =
      "http://apicloud.mob.com/v1/weather/query?key=248dc56241a12&province=北京&city=北京";
//  getRequest(url, (String data) {
//    MobApiResultBean mobApiResultBean =
//        MobApiResultBean.fromJson(json.decode(data));
//    WeatherBean weatherBean = WeatherBean.fromJson(
//        json.decode(json.encode(mobApiResultBean.result.elementAt(0))));
//    print(weatherBean);
//    weatherView.weatherState.setWeatherBean(weatherBean);
//  }, (int errorCode) {
//    print(errorCode);
//  });
}
