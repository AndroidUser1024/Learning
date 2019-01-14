import 'package:http/http.dart';

getRequest(String url, onSuccessCallback, onErrorCallback) async {
  try {
    Client client = new Client();
    final response = await client.get(url);
    if (response.statusCode == 200) {
      onSuccessCallback(response.body);
    } else {
      onErrorCallback(response.statusCode);
    }
  } catch (e) {
    print(e);
  }
}
