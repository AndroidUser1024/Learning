import 'package:flutter/material.dart';
import 'dart:ui';

void main(){
  runApp(widgetForRoute(window.defaultRouteName));
}

Widget widgetForRoute(String route) {
  switch (route) {
    case "HomePage":
      return MaterialApp(
        title: "Demo",
        home: Scaffold(
          appBar: AppBar(
            title: Text("Demo"),
          ),
          body: Center(
            child: Text(
              "Hello World",
              style: TextStyle(fontSize: 40, color: Color(0xFF000000)),
            ),
          ),
        ),
      );
  }
}
