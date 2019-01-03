class WeatherBean {
  String airCondition; //空气质量
  String city; //城市
  String coldIndex; //感冒指数
  String updateTime; //更新时间的时间戳
  String date; //日期
  String district; //区县
  String dressingIndex; //穿衣指数
  String humidity; //湿度
  int pollutionIndex; //空气质量指数
  String province; //省份
  String sunset; //日落时间
  String sunrise; //日出时间
  String temperature; //温度
  String time; //时间
  String washIndex; //洗车指数
  String weather; //天气
  String week; //星期几
  String wind; //风向
  String exerciseIndex; //运动指数
  String dayTime; //白天天气
  String night; //晚上天气
  List<WeatherBean> future; //未来一周的天气

  WeatherBean();

  @override
  String toString() {
    return 'WeatherBean{airCondition: $airCondition, city: $city, coldIndex: $coldIndex, updateTime: $updateTime, date: $date, district: $district, dressingIndex: $dressingIndex, humidity: $humidity, pollutionIndex: $pollutionIndex, province: $province, sunset: $sunset, sunrise: $sunrise, temperature: $temperature, time: $time, washIndex: $washIndex, weather: $weather, week: $week, wind: $wind, exerciseIndex: $exerciseIndex, dayTime: $dayTime, night: $night, future: $future}';
  }
}
