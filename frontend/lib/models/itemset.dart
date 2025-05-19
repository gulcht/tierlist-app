class Itemset {
  final int id;
  final String name;

  Itemset({required this.id, required this.name});

  factory Itemset.fromJson(Map<String, dynamic> json) {
    return Itemset(id: json['id'], name: json['name']);
  }
}
