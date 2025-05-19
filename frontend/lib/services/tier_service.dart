import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:tierlistapp/models/tier.dart';

class TierService {
  Future<List<Tier>> loadTiers() async {
    final response =
        await http.get(Uri.parse('http://127.0.0.1:8080/api/tiers'));
    if (response.statusCode == 200) {
      final List<dynamic> tierJsonList = json.decode(response.body);

      List<Tier> tiers =
          tierJsonList.map((json) => Tier.fromJson(json)).toList();

      return tiers;
    } else {
      throw Exception('Failed to load tiers');
    }
  }
}
