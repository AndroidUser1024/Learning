class ArticleBean {
  String _id;
  String createAt;
  String description;
  List<dynamic> images;
  String publishedAt;
  String source;
  String type;
  String url;
  bool used;
  String who;

  ArticleBean.fromJson(Map<String, dynamic> jsonMap)
      : _id = jsonMap['_id'],
        createAt = jsonMap['createAt'],
        description = jsonMap['desc'],
        images = jsonMap['images'],
        publishedAt = jsonMap['publishedAt'],
        source = jsonMap['source'],
        type = jsonMap['type'],
        url = jsonMap['url'],
        used = jsonMap['used'],
        who = jsonMap['who'];

  @override
  String toString() {
    return 'ArticleBean{_id: $_id, createAt: $createAt, description: $description, images: $images, publishedAt: $publishedAt, source: $source, type: $type, url: $url, used: $used, who: $who}';
  }

}
