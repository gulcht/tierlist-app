class Item {
  final int id;
  final String image;

  Item({
    required this.id,
    required this.image,
  });

  factory Item.fromJson(Map<String, dynamic> json) {
    return Item(
      id: json['id'] as int,
      image: json['image'] as String,
    );
  }
}

class Items {
  late List<Item> items = [];

  Items({required this.items});

  factory Items.fromJson(Map<String, dynamic> json) {
    final List<dynamic> jsonItems = json['items'];
    final List<Item> items =
        jsonItems.map((itemJson) => Item.fromJson(itemJson)).toList();

    return Items(items: items);
  }
}
