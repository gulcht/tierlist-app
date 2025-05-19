import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:tierlistapp/models/tierlist_item.dart';

class TierListItemService {
  Future<List<TierListItem>> getTierListItemByTierListId(String id) async {
    final response = await http
        .get(Uri.parse('http://localhost:8080/api/tierListItems/$id'));

    if (response.statusCode == 200) {
      final List<dynamic> jsonData = jsonDecode(response.body);
      return jsonData
          .map((itemJson) => TierListItem.fromJson(itemJson))
          .toList();
    } else {
      throw Exception('Failed to load items by itemsetId');
    }
  }
}
