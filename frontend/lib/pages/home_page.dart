import 'package:flutter/material.dart';
import 'package:tierlistapp/auth/user_preferences.dart';
import 'package:tierlistapp/components/my_button.dart';
import 'package:tierlistapp/components/my_drawer.dart';
import 'package:tierlistapp/models/tierlist.dart';
import 'package:tierlistapp/pages/tier_maker_page.dart';
import 'package:tierlistapp/services/tierlist_service.dart';

class HomePage extends StatelessWidget {
  final TierListService tierListService = TierListService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      appBar: AppBar(
        title: const Text(
          "H O M E",
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
        backgroundColor: Colors.transparent,
        foregroundColor: Theme.of(context).colorScheme.inversePrimary,
        elevation: 0,
      ),
      drawer: MyDrawer(),
      body: Center(
        child: Column(
          children: [
            FutureBuilder<List<TierList>?>(
              future: loadTierLists(),
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Center(child: CircularProgressIndicator());
                } else if (snapshot.hasError) {
                  return Center(child: Text('Error: ${snapshot.error}'));
                } else if (snapshot.hasData && snapshot.data!.isNotEmpty) {
                  return SizedBox(
                    height: 200,
                    child: ListView(
                      children: snapshot.data!.map((tier) {
                        return Padding(
                          padding: const EdgeInsets.only(left: 12, right: 12),
                          child: ListTile(
                            title: Text(tier.name),
                            onTap: () {
                              Navigator.push(
                                context,
                                MaterialPageRoute(
                                  builder: (context) => TierMaker(
                                    tierListId: tier.id,
                                    key: key,
                                  ),
                                ),
                              );
                            },
                            trailing: Icon(
                              Icons.arrow_right_outlined,
                              color:
                                  Theme.of(context).colorScheme.inversePrimary,
                              size: 30,
                            ),
                          ),
                        );
                      }).toList(),
                    ),
                  );
                } else {
                  return Center(child: Text('No tier lists available.'));
                }
              },
            ),
            Padding(
              padding: const EdgeInsets.all(12),
              child: MyBotton(
                  text: 'Create a Tier List',
                  onTap: () {
                    Navigator.pushNamed(context, 'tiermaker');
                  }),
            )
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        elevation: 0.1,
        backgroundColor: Theme.of(context).colorScheme.primary,
        foregroundColor: Theme.of(context).colorScheme.inversePrimary,
        onPressed: () {
          Navigator.pushNamed(context, 'itemset');
          ;
        },
        child: Icon(Icons.add_rounded),
      ),
    );
  }

  Future<List<TierList>?> loadTierLists() async {
    int? userId = await UserPreferences.getUserId();

    if (userId != null) {
      return await tierListService.getTierListsByUserId(userId);
    } else {
      print("userId is Null");
      return null;
    }
  }
}
