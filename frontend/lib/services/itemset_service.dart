import 'dart:convert';
import 'dart:io';
import 'dart:typed_data';

import 'package:http/http.dart' as http;
import 'package:tierlistapp/models/itemset.dart';

class ItemsetService {
  Future<String> img2Text(File imgPath) async {
    File imageFile = imgPath;
    Uint8List imageBytes = await imageFile.readAsBytes();
    return base64.encode(imageBytes);
  }

  Future<void> saveItems(int itemsetId, List<File?> list) async {
    Uri url = Uri.parse("http://127.0.0.1:8080/api/items");
    for (int i = 0; i < list.length; i++) {
      String imgText = await img2Text(list[i]!);
      Map<String, dynamic> itemsData = {
        "itemset": {"id": itemsetId},
        "image": imgText,
      };

      var response = await http.post(
        url,
        headers: {
          "Content-Type": "application/json",
        },
        body: json.encode(itemsData),
      );

      if (response.statusCode == 201) {
        print('added Items');
      }
    }
  }

  Future<void> createItemset(
      File? mainImage, String enteredText, List<File?> list) async {
    Uri url = Uri.parse("http://127.0.0.1:8080/api/itemsets");

    String mainImageText = await img2Text(mainImage!);
    Map<String, dynamic> itemsetData = {
      "name": enteredText,
      "image": mainImageText,
    };

    var response = await http.post(
      url,
      headers: {
        "Content-Type": "application/json",
      },
      body: json.encode(itemsetData),
    );

    if (response.statusCode == 201) {
      print("itemset created successfully.");

      int itemsetId = int.parse(response.body);
      saveItems(itemsetId, list);
    } else {
      print("Failed to create itemset. Status code: ${response.statusCode}");
    }
  }

  Future<List<Itemset>?> getItemsets() async {
    try {
      final response =
          await http.get(Uri.parse('http://127.0.0.1:8080/api/itemsets'));

      if (response.statusCode == 200) {
        final List<dynamic> data = json.decode(response.body);
        return data.map((itemsetData) {
          return Itemset.fromJson(itemsetData);
        }).toList();
      }
    } catch (e) {
      print('Failed to load sets: $e');
    }
    return null;
  }
}
