import 'package:flutter/material.dart';
import 'package:tierlistapp/components/my_button.dart';
import 'package:tierlistapp/components/my_textfield.dart';
import 'package:tierlistapp/services/user_service.dart';

// ignore: must_be_immutable
class RegisterPage extends StatelessWidget {
  final void Function()? onTap;

  RegisterPage({super.key, required this.onTap});

  UserService userService = UserService();
  // text controllers
  TextEditingController emailController = TextEditingController();
  TextEditingController usernameController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  TextEditingController confirmPasswordController = TextEditingController();

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

            Text(
              "R E G I S T E R",
              style: TextStyle(fontSize: 20),
            ),

            const SizedBox(
              height: 50,
            ),
            // email textfield
            MyTextField(
              hintText: "Username",
              obscureText: false,
              controller: usernameController,
              filled: false,
            ),

            const SizedBox(
              height: 10,
            ),

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

            MyTextField(
              hintText: "Confirm Password",
              obscureText: true,
              controller: confirmPasswordController,
              filled: false,
            ),

            const SizedBox(
              height: 25,
            ),

            MyBotton(
                text: "Register",
                onTap: () async {
                  final registerSuccess = await userService.register(
                      usernameController.text,
                      emailController.text,
                      passwordController.text,
                      confirmPasswordController.text);
                  if (registerSuccess) {
                    Navigator.pushNamed(context, 'login_or_register');
                  } else {
                    // Handle the case where login failed
                  }
                }),

            const SizedBox(
              height: 10,
            ),

            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "Already have an account?",
                  style: TextStyle(
                      color: Theme.of(context).colorScheme.inversePrimary),
                ),
                GestureDetector(
                  onTap: onTap,
                  child: const Text(
                    " Login Here",
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
