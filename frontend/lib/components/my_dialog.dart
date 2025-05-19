// import 'package:flutter/material.dart';
// import 'package:tierlistapp/components/my_textfield.dart';

// Future<void> addItemSet(BuildContext context) {
//   return showDialog<void>(
//     context: context,
//     builder: (BuildContext context) {
//       return AlertDialog(
//         title: const Text('Add a Tier'),
//         content: MyTextField,
//         actions: <Widget>[
//           TextButton(
//             style: TextButton.styleFrom(
//               textStyle: Theme.of(context).textTheme.labelLarge,
//             ),
//             child: const Text('Cancel'),
//             onPressed: () {
//               Navigator.of(context).pop();
//             },
//           ),
//           TextButton(
//             style: TextButton.styleFrom(
//               textStyle: TextStyle(
//                   color: Theme.of(context).colorScheme.inversePrimary),
//             ),
//             child: const Text('Add'),
//             onPressed: () {
//               Navigator.of(context).pop();
//             },
//           ),
//         ],
//       );
//     },
//   );
// }
