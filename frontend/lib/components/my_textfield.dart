import 'package:flutter/material.dart';

class MyTextField extends StatelessWidget {
  final String hintText;
  final bool obscureText;
  final TextEditingController controller;
  final bool filled;

  const MyTextField(
      {super.key,
      required this.hintText,
      required this.obscureText,
      required this.controller,
      required this.filled});

  @override
  Widget build(BuildContext context) {
    return TextField(
      controller: controller,
      obscureText: obscureText,
      decoration: InputDecoration(
        filled: filled,
        fillColor: Theme.of(context).colorScheme.primary,
        hintText: hintText,
        border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
        enabledBorder: OutlineInputBorder(
          borderSide: BorderSide(
              width: 1, color: Theme.of(context).colorScheme.primary),
          borderRadius: BorderRadius.circular(12),
        ),
      ),
    );
  }
}
