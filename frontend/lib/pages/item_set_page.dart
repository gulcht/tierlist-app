import 'dart:io';

import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:tierlistapp/components/my_button.dart';
import 'package:tierlistapp/components/my_textfield.dart';
import 'package:tierlistapp/pages/home_page.dart';
import 'package:tierlistapp/services/itemset_service.dart';

class ItemSetPage extends StatefulWidget {
  ItemSetPage({super.key});

  @override
  _ItemSetState createState() => _ItemSetState();
}

class _ItemSetState extends State<ItemSetPage> {
  ImagePicker picker = ImagePicker();
  TextEditingController nameController = TextEditingController();
  List<File?> imageList = [];
  File? mainImage;
  ItemsetService itemsetService = ItemsetService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      appBar: AppBar(
        title: const Text("A D D  S E T"),
        backgroundColor: Colors.transparent,
        foregroundColor: Theme.of(context).colorScheme.inversePrimary,
        elevation: 0,
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(25.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              GestureDetector(
                onTap: selectMainImage,
                child: Container(
                  height: 150,
                  width: 150,
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(25),
                    child: mainImage != null
                        ? Image.file(mainImage!, fit: BoxFit.cover)
                        : Icon(
                            Icons.photo_outlined,
                            size: 80,
                            color: Theme.of(context).colorScheme.inversePrimary,
                          ),
                  ),
                ),
              ),
              const SizedBox(height: 25),
              MyTextField(
                hintText: "Name",
                obscureText: false,
                controller: nameController,
                filled: false,
              ),
              SizedBox(
                height: 10,
              ),
              Expanded(
                child: Container(
                  decoration: BoxDecoration(
                    border: Border.all(
                      color: Theme.of(context).colorScheme.primary,
                      width: 2.0,
                    ),
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Card(
                      color: Theme.of(context).colorScheme.background,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                        side: BorderSide.none,
                      ),
                      elevation: 0,
                      child: GridView.builder(
                        gridDelegate:
                            const SliverGridDelegateWithFixedCrossAxisCount(
                          crossAxisCount: 4,
                          mainAxisSpacing: 4,
                        ),
                        itemCount: imageList.length + 1,
                        itemBuilder: (BuildContext context, int index) {
                          if (index == 0) {
                            return Center(
                              child: GestureDetector(
                                onTap: selectImages,
                                child: Container(
                                  width: 100,
                                  height: 100,
                                  child: Icon(
                                    Icons.photo_library_outlined,
                                    size: 50,
                                    color: Theme.of(context)
                                        .colorScheme
                                        .inversePrimary,
                                  ),
                                ),
                              ),
                            );
                          } else if (index <= imageList.length) {
                            final File? image = imageList[index - 1];
                            if (image != null) {
                              return Stack(
                                children: [
                                  Padding(
                                    padding: const EdgeInsets.all(8),
                                    child: ClipRRect(
                                      borderRadius: BorderRadius.circular(12),
                                      child: Image.file(
                                        image,
                                        width: 100,
                                        height: 100,
                                        fit: BoxFit.cover,
                                      ),
                                    ),
                                  ),
                                  Positioned(
                                    top: -12,
                                    right: -12,
                                    child: Container(
                                      // padding: const EdgeInsets.all(0),
                                      child: IconButton(
                                        icon: Icon(Icons.remove_circle_outlined,
                                            color: Theme.of(context)
                                                .colorScheme
                                                .inversePrimary),
                                        onPressed: () {
                                          setState(() {
                                            imageList.removeAt(index - 1);
                                          });
                                        },
                                      ),
                                    ),
                                  ),
                                ],
                              );
                            }
                          }
                          return Container();
                        },
                      )),
                ),
              ),
              SizedBox(
                height: 10,
              ),
              Padding(
                padding: const EdgeInsets.only(left: 25, right: 25, bottom: 25),
                child: MyBotton(
                  text: 'Save',
                  onTap: () async {
                    itemsetService.createItemset(
                        mainImage, nameController.text, imageList);
                    print('pressed');
                    Navigator.of(context).push(MaterialPageRoute(
                      builder: (context) => HomePage(),
                    ));
                  },
                ),
              )
            ],
          ),
        ),
      ),
    );
  }

  Future<void> selectMainImage() async {
    final pickedFile = await picker.pickImage(source: ImageSource.gallery);
    if (pickedFile != null) {
      setState(() {
        mainImage = File(pickedFile.path);
      });
    } else {
      print('No image selected.');
    }
  }

  Future<void> selectImages() async {
    List<XFile> pickedFiles = [];
    final pickerResult = await picker.pickMultiImage();
    if (pickerResult.isNotEmpty) {
      pickedFiles = List.from(pickerResult);

      List<File?> files = pickedFiles.map((xFile) => File(xFile.path)).toList();

      setState(() {
        imageList.addAll(files);
      });
    } else {
      print('No images selected.');
    }
  }
}
