import 'package:tierlistapp/models/item.dart';
import 'package:tierlistapp/models/tier.dart';
import 'package:tierlistapp/models/tierlist.dart';

class TierListItem {
  final int id;
  final TierList tierlist;
  final Item item;
  final Tier tier;

  TierListItem(
      {required this.id,
      required this.tierlist,
      required this.item,
      required this.tier});

  factory TierListItem.fromJson(Map<String, dynamic> json) {
    return TierListItem(
      id: json['id'],
      tierlist: TierList.fromJson(json['tierlist']),
      item: Item.fromJson(json['item']),
      tier: Tier.fromJson(json['tier']),
    );
  }
}
