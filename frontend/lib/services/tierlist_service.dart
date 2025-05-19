import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:tierlistapp/models/tierlist.dart';

class TierListService {
  Future<List<TierList>> getTierListsByUserId(int userId) async {
    final response = await http
        .get(Uri.parse('http://localhost:8080/api/users/$userId/tierLists'));

    if (response.statusCode == 200) {
      List<dynamic> tierListJson = json.decode(response.body);
      List<TierList> tierLists =
          tierListJson.map((json) => TierList.fromJson(json)).toList();
      return tierLists;
    } else {
      throw Exception('Failed to load tier lists');
    }
  }
}
