 import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:tierlistapp/components/my_dropdown.dart';
import 'package:tierlistapp/models/item.dart';
import 'package:tierlistapp/models/tier.dart';
import 'package:tierlistapp/pages/mergedTierItem.dart';
import 'package:tierlistapp/services/item_service.dart';
import 'package:tierlistapp/services/tier_service.dart';
import 'package:tierlistapp/services/tierlist_item_service.dart';
import 'dart:typed_data';

class TierMaker extends StatefulWidget {
  final tierListId;

  TierMaker({Key? key, this.tierListId}) : super(key: key);

  @override
  _TierMakerState createState() => _TierMakerState();
}

class _TierMakerState extends State<TierMaker> {
  List<Item> items = [];
  List<Tier> tiers = [];
  ItemService itemService = ItemService();
  String? selectedItemset;
  List<Items> tierListItems = [];

  late MergedTierListItem mergedTierListItem;

  TextEditingController tierController = TextEditingController();
  TierService tierService = TierService();
  String name = '';

  @override
  void initState() {
    loadTiers();
    super.initState();
    setState(() {});
  }

  @override
  void dispose() {
    tierController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("T I E R  L I S T"),
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        elevation: 0,
      ),
      body: Padding(
        padding: const EdgeInsets.all(15.0),
        child: Center(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              MyDropdown(onItemsetSelected: (itemset) async {
                setState(() {
                  selectedItemset = itemset;
                });

                loadItemset();
              }),
              SizedBox(height: 20),
              Container(
                child: Expanded(
                  child: ListView.builder(
                    itemBuilder: (context, index) {
                      if (index < tiers.length) {
                        Tier tier = tiers[index];

                        return ListTile(
                          leading: Card(
                            child: Text(tier.name.toString()),
                          ),
                          tileColor: Colors.teal,
                          title: DragTarget<Item>(
                            // Add the generic type here
                            builder: (BuildContext context,
                                List<Object?> candidateData,
                                List<dynamic> rejectedData) {
                              return Container(
                                height: 100,
                                width: 100,
                                color: Colors.red,
                              );
                            },
                            onAccept: (Item data) {
                              if (data is Item) {
                                tierListItems[index].items.add(data);
                                print('Object added');
                              }
                            },
                            onWillAccept: (data) {
                              print('will accept');
                              return data
                                  is Item; // Make sure the data is of the correct type
                            },
                          ),
                        );
                      } else {
                        return null; // Return null for indices that are out of bounds
                      }
                    },
                  ),
                ),
              ),
              SizedBox(height: 20),
              if (items.isNotEmpty)
                buildDraggableItem(items)
              else
                const Text('No Items Available'),
            ],
          ),
        ),
      ),
    );
  }

  // Function to fetch items and update the list
  Future<void> loadItemset() async {
    List<Item> fetchedItems =
        await itemService.getItemsByItemsetId(selectedItemset!);
    setState(() {
      items = fetchedItems;
    });
  }

  Future<void> loadTiers() async {
    try {
      List<Tier> fetchedItems = await tierService.loadTiers();
      setState(() {
        tiers = fetchedItems;
        // print('tiers');
      });
    } catch (e) {
      print('Error loading tiers: $e');
    }
  }

  Widget buildDraggableItem(List<Item> listItem) {
    return Expanded(
      child: GridView.builder(
        gridDelegate: SliverGridDelegateWithMaxCrossAxisExtent(
          maxCrossAxisExtent: 100, // Set the maximum width for each item
          crossAxisSpacing: 8,
          mainAxisSpacing: 8,
        ),
        itemCount: listItem.length,
        itemBuilder: (context, index) {
          final item = listItem[index];
          return Draggable(
            data: item,
            feedback: ClipRRect(
              borderRadius: BorderRadius.circular(12),
              child: Container(
                width: 72,
                height: 72,
                color: Colors.grey.withOpacity(0.8),
                child: getImageWidget(item.image),
              ),
            ),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(12),
              child: Container(
                width: 72,
                height: 72,
                color: Colors.grey,
                child: getImageWidget(item.image),
              ),
            ),
          );
        },
      ),
    );
  }

  Widget getImageWidget(String? base64Image) {
    if (base64Image != null) {
      final imageBytes = decodeBase64Safe(base64Image);
      if (imageBytes != null) {
        return Image.memory(
          imageBytes,
          fit: BoxFit.cover,
        );
      }
    }
    return const SizedBox(
      width: 72,
      height: 72,
    );
  }

  Future<String?> openDialog() => showDialog<String>(
      context: context,
      builder: (context) => AlertDialog(
            title: Text('Add a Tier'),
            content: TextField(
              autofocus: true,
              decoration: InputDecoration(hintText: 'Enter tier name'),
              controller: tierController,
            ),
            actions: [
              TextButton(
                  onPressed: () {
                    submit();
                  },
                  child: Text(
                    'Add',
                    style: TextStyle(
                        color: Theme.of(context).colorScheme.inversePrimary),
                  ))
            ],
          ));

  void submit() {
    Navigator.of(context).pop(tierController.text);
    tierController.clear();
  }

  Uint8List? decodeBase64Safe(String base64String) {
    try {
      return base64.decode(base64String);
    } catch (e) {
      return null;
    }
  }
}
