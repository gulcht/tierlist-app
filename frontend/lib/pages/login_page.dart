import 'package:flutter/material.dart';
import 'package:tierlistapp/components/my_button.dart';
import 'package:tierlistapp/components/my_textfield.dart';
import 'package:tierlistapp/services/user_service.dart';

// ignore: must_be_immutable
class LoginPage extends StatelessWidget {
  final void Function()? onTap;

  LoginPage({super.key, required this.onTap});

  // text controllers
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  UserService userService = UserService();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      body: Center(
          child: Padding(
        padding: const EdgeInsets.all(25.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            // logo
            Icon(
              Icons.person,
              size: 80,
              color: Theme.of(context).colorScheme.inversePrimary,
            ),

            const SizedBox(
              height: 25,
            ),

            const Text(
              "L O G I N",
              style: TextStyle(fontSize: 20),
            ),

            const SizedBox(
              height: 50,
            ),
            // email textfield
            MyTextField(
              hintText: "Email",
              obscureText: false,
              controller: emailController,
              filled: false,
            ),

            const SizedBox(
              height: 10,
            ),

            MyTextField(
              hintText: "Password",
              obscureText: true,
              controller: passwordController,
              filled: false,
            ),

            const SizedBox(
              height: 10,
            ),

            Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                Text(
                  "Forgot Password?",
                  style: TextStyle(
                      color: Theme.of(context).colorScheme.inversePrimary),
                )
              ],
            ),

            const SizedBox(
              height: 25,
            ),

            MyBotton(
              text: "Login",
              onTap: () async {
                final loginSuccess = await userService.login(
                    emailController.text, passwordController.text);
                if (loginSuccess) {
                  Navigator.pushNamed(context, 'home');
                } else {
                  Text('Login failed.');
                }
              },
            ),

            const SizedBox(
              height: 10,
            ),

            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "Don't have an account?",
                  style: TextStyle(
                      color: Theme.of(context).colorScheme.inversePrimary),
                ),
                GestureDetector(
                  onTap: onTap,
                  child: const Text(
                    " Register Here",
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                )
              ],
            ),
          ],
        ),
      )),
    );
  }
}
