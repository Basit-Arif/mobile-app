

import 'package:assignment_1/main.dart';
import 'package:flutter/cupertino.dart';
import "package:flutter/material.dart";
import "package:shared_preferences/shared_preferences.dart";
class homescreen extends StatefulWidget {
  const homescreen({Key? key}) : super(key: key);

  @override
  _homescreenState createState() => _homescreenState();
}

class _homescreenState extends State<homescreen> {

  void initState(){
    super.initState();

  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("Homescreen"),),
        body: ElevatedButton(onPressed: ()  {
         final pref = SharedPreferences.getInstance().then((pref){
           pref.remove("email");
           Navigator.push(context, MaterialPageRoute(builder: (context)=>MyApp()));
         });
        }, child: Text("Signout"),)
      ),
    );
  }
}

