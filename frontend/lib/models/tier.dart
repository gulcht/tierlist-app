class Tier {
  final int id;
  final String? name;

  Tier({required this.id, this.name});

  factory Tier.fromJson(Map<String, dynamic> json) {
    return Tier(
      id: json['id'],
      name: json['name'],
    );
  }
}
