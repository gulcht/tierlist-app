import 'package:tierlistapp/models/item.dart';
import 'package:tierlistapp/models/tier.dart';
import 'package:tierlistapp/models/tierlist.dart';
import 'package:tierlistapp/models/tierlist_item.dart';

class MergedTierListItem {
  final TierList tierList;
  final Tier tier;
  final List<Item> items;

  MergedTierListItem({
    required this.tierList,
    required this.tier,
    required this.items,
  });

  factory MergedTierListItem.fromTierListItemList(
      List<TierListItem> tierListItems) {
    final mergedTierListItem = MergedTierListItem(
      tierList: tierListItems[0].tierlist,
      tier: tierListItems[0].tier,
      items: tierListItems.map((tierListItem) => tierListItem.item).toList(),
    );

    return mergedTierListItem;
  }
}
