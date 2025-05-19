import 'dart:convert';

import 'package:tierlistapp/models/item.dart';
import 'package:http/http.dart' as http;

class ItemService {
  Future<List<Item>> getItemsByItemsetId(String id) async {
    final response = await http
        .get(Uri.parse('http://localhost:8080/api/itemsets/$id/items'));

    if (response.statusCode == 200) {
      final List<dynamic> jsonData = jsonDecode(response.body);
      return jsonData.map((itemJson) => Item.fromJson(itemJson)).toList();
    } else {
      throw Exception('Failed to load items by itemsetId');
    }
  }
}
