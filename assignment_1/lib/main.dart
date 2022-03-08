import 'package:flutter/material.dart';
import "Api_call.dart";
import 'package:http/http.dart' as Http;
import 'package:shared_preferences/shared_preferences.dart';
import "main2.dart";
// SharedPreferences localStorage;
Future<void> main() async {

  runApp(MyApp());
}
SharedPreferences pref= SharedPreferences.getInstance() as SharedPreferences;
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return  MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.green,
      ),
      title: "Assignment_1",
      home: const Myhomepage(),
      );
  }
}
class Myhomepage extends StatefulWidget {
  const Myhomepage({Key? key,}) : super(key: key);

  // final Api_call;
  @override
  _MyhomepageState createState() => _MyhomepageState();

}

class _MyhomepageState extends State<Myhomepage> {
  final _email = TextEditingController();
  final _password = TextEditingController();
  void login() async{
    final login_check= await Http.post(Uri.parse("https://reqres.in/api/login"),
        body: {
          "email": _email.text,
          "password": _password.text
        }
    );
    if (login_check.statusCode == 200) {
      final pref = await SharedPreferences.getInstance();
      pref.setString("email","basit");
      print(pref);
      Navigator.push(context,MaterialPageRoute(builder: (context) => homescreen()));
  }
  }
  // Map<String,String> user =jsonDecode(source)
  void register() async {
    final url=await Http.post(Uri.parse("https://reqres.in/api/register"),
        body: {
          "email": _email.text,
          "password": _password.text
        });
    // if(url == 200)
    if (url.statusCode == 200) {
      final pref = await SharedPreferences.getInstance();
      pref.setString("email","basit2");
      Navigator.push(context,MaterialPageRoute(builder: (context) => homescreen()));
    }
  }
  void initState()  {
    final pref = SharedPreferences.getInstance().then((pref){
      if(pref.containsKey("email")){
        Navigator.push(context, MaterialPageRoute(builder: (context) => homescreen()));
      }
    });
    super.initState();

  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Signin"),),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Padding(
            padding: const EdgeInsets.only(left: 10,right: 10,top: 10,bottom: 10),
            child: TextFormField(
              controller: _email,
              keyboardType: TextInputType.text,
              decoration: const InputDecoration(
                fillColor: Colors.white,
                filled: true,
                border: UnderlineInputBorder(),
                labelText:"email"
              ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.only(left: 10,right: 10,top: 10,bottom: 10),
            child: TextFormField(
              keyboardType: TextInputType.visiblePassword,
              controller: _password,
              decoration: const InputDecoration(
                  fillColor: Colors.white,
                  filled: true,
                  border: UnderlineInputBorder(),
                  labelText:"password"
              ),
            ),
          ),
          Padding(
              padding: const EdgeInsets.only(left: 10,right: 10,top: 10,bottom: 10),
            child: ElevatedButton(
              onPressed: login
              , child: Text("Signin"),
            ),
          ),
          Padding(
            padding: const EdgeInsets.only(left: 10,right: 10,top: 10,bottom: 10),
            child: ElevatedButton(
              onPressed: register
              , child: Text("Register with same detail"),
            ),
          )
        ],
      ),

    );
  }
}




