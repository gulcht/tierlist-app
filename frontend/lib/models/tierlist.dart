class TierList {
  final int id;
  final String name;

  TierList({required this.id, required this.name});

  factory TierList.fromJson(Map<String, dynamic> json) {
    return TierList(
      id: json['id'],
      name: json['name'],
      // image: json['image'],
    );
  }
}
