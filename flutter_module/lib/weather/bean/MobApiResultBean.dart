class MobApiResultBean {
  String msg;
  String retCode;
  List<dynamic> result;

  MobApiResultBean.fromJson(Map<String, dynamic> jsonMap)
      : msg = jsonMap['msg'],
        retCode = jsonMap['retCode'],
        result = jsonMap['result'];

  @override
  String toString() {
    return 'MobApiResultBean{msg: $msg, retCode: $retCode, result: $result}';
  }

}
