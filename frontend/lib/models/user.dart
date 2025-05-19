class User {
  final int id;
  final String? email;
  final String? username;
  final String? image;

  User({required this.id, this.email, this.username, this.image});

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      id: json['id'],
      email: json['email'],
      username: json['username'],
      image: json['image'],
    );
  }
}
