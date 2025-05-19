import 'package:flutter/material.dart';
import 'package:tierlistapp/auth/user_preferences.dart';

class MyDrawer extends StatelessWidget {
  const MyDrawer({super.key});

  Future logout() async {
    await UserPreferences.setUserId(0);
    await UserPreferences.setLoginStatus(false);
  }

  @override
  Widget build(BuildContext context) {
    return Drawer(
      backgroundColor: Theme.of(context).colorScheme.background,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Column(
            children: [
              DrawerHeader(
                  child: Icon(
                Icons.star_rounded,
                size: 32,
                color: Theme.of(context).colorScheme.inversePrimary,
              )),
              const SizedBox(
                height: 25,
              ),
              Padding(
                padding: const EdgeInsets.only(left: 25),
                child: ListTile(
                  leading: Icon(
                    Icons.home,
                    color: Theme.of(context).colorScheme.inversePrimary,
                  ),
                  title: Text("H O M E"),
                  onTap: () {
                    Navigator.pop(context);
                    Navigator.pushNamed(context, 'home');
                  },
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(left: 25),
                child: ListTile(
                  leading: Icon(
                    Icons.person,
                    color: Theme.of(context).colorScheme.inversePrimary,
                  ),
                  title: Text("P R O F I L E"),
                  onTap: () {
                    Navigator.pop(context);
                    Navigator.pushNamed(context, 'profile');
                  },
                ),
              ),
            ],
          ),
          Padding(
            padding: const EdgeInsets.only(left: 25, bottom: 25),
            child: ListTile(
              leading: Icon(
                Icons.logout,
                color: Theme.of(context).colorScheme.inversePrimary,
              ),
              title: Text("L O G O U T"),
              onTap: () {
                Navigator.pop(context);
                logout();
                Navigator.pushNamed(context, 'login_or_register');
              },
            ),
          ),
        ],
      ),
    );
  }
}
