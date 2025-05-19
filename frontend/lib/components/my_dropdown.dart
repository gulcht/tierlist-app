import 'package:flutter/material.dart';

import 'package:tierlistapp/models/itemset.dart';
import 'package:tierlistapp/services/itemset_service.dart';

class MyDropdown extends StatefulWidget {
  final Function(String?) onItemsetSelected;

  MyDropdown({required this.onItemsetSelected});

  @override
  _MyDropdownState createState() => _MyDropdownState();
}

class _MyDropdownState extends State<MyDropdown> {
  String? selectedItemset;
  List<Itemset> itemsets = [];
  bool loading = true;
  ItemsetService itemsetService = ItemsetService();
  @override
  void initState() {
    super.initState();
    itemsetService.getItemsets().then((list) {
      setState(() {
        itemsets = list!;
        loading = false;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return loading
        ? CircularProgressIndicator()
        : Container(
            decoration: BoxDecoration(
                // border: Border.all(),
                ),
            child: DropdownButtonFormField(
              decoration: InputDecoration(
                enabledBorder: OutlineInputBorder(
                  borderSide: BorderSide.none,
                ),
                border: OutlineInputBorder(
                  borderSide: BorderSide.none,
                ),
              ),
              value: selectedItemset,
              items: itemsets.map((Itemset itemset) {
                return DropdownMenuItem<String>(
                  value: itemset.id.toString(),
                  child: Text(itemset.name),
                );
              }).toList(),
              onChanged: (String? newValue) {
                setState(() {
                  selectedItemset = newValue;
                  widget.onItemsetSelected(selectedItemset);
                });
              },
              hint: Text("Please choose Set"),
            ),
          );
  }
}
