import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'PetNatu',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Login'),
        ),
        body: Center(
          child: Text('Hello World'),
        ),
      ),
    );
  }

}