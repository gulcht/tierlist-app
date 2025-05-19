import 'package:flutter/material.dart';
import 'package:tierlistapp/auth/check_login.dart';
import 'package:tierlistapp/auth/login_or_register.dart';
import 'package:tierlistapp/pages/home_page.dart';
import 'package:tierlistapp/pages/item_set_page.dart';
import 'package:tierlistapp/pages/profile_page.dart';
import 'package:tierlistapp/pages/tier_maker_page.dart';

import 'package:tierlistapp/theme/dark_mode.dart';
import 'package:tierlistapp/theme/light_mode.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: CheckLogin(),
      theme: lightMode,
      darkTheme: darkMode,
      routes: {
        'login_or_register': (context) => LoginOrRegister(),
        'home': (context) => HomePage(),
        'profile': (context) => ProfilePage(),
        'itemset': (context) => ItemSetPage(),
        'tiermaker': (context) => TierMaker(),
      },
    );
  }
}
