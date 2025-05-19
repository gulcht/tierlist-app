import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:tierlistapp/components/my_backbotton.dart';
import 'package:tierlistapp/models/user.dart';
import 'package:tierlistapp/auth/user_preferences.dart';
import 'package:tierlistapp/services/user_service.dart';

class ProfilePage extends StatelessWidget {
  final UserService userService = UserService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      body: FutureBuilder<User?>(
        future: loadUserData(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(
              child: CircularProgressIndicator(),
            );
          } else if (snapshot.hasError) {
            print('Error loading user data: ${snapshot.error}');
            return Center(
              child: Text('Error loading user data: ${snapshot.error}'),
            );
          } else if (snapshot.hasData) {
            final user = snapshot.data!;
            return Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Container(
                    decoration: BoxDecoration(
                      color: Theme.of(context).colorScheme.primary,
                      borderRadius: BorderRadius.circular(24),
                    ),
                    padding: const EdgeInsets.all(25),
                    child: user.image != null
                        ? Image.memory(base64Decode(user.image!))
                        : Icon(
                            Icons.person,
                            size: 64,
                          ), // Display the default icon if user.image is null
                  ),
                  const SizedBox(
                    height: 25,
                  ),
                  Text(
                    '${user.username}',
                    style: const TextStyle(
                      fontSize: 24,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  const SizedBox(
                    height: 10,
                  ),
                  Text(
                    '${user.email}',
                    style: TextStyle(fontSize: 18, color: Colors.grey[600]),
                  ),
                  const SizedBox(
                    height: 50,
                  ),
                  const MyBackButton(),
                ],
              ),
            );
          } else {
            return Container();
          }
        },
      ),
    );
  }

  Future<User?> loadUserData() async {
    final userId = await UserPreferences.getUserId();

    if (userId != null) {
      final user = await userService.getUserById(userId);
      return user;
    } else {
      print("userId is Null");
      return null;
    }
  }
}

// Rest of your code remains unchanged.
