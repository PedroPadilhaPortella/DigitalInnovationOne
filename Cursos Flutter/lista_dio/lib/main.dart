import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Lista DIO'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<Contato> contatos = [];

  @override
  void initState() {
    super.initState();
    contatos.add(new Contato(
        nome: 'Pedro Portella',
        telefone: '(11)98765432',
        tipo: ContatoType.CELULAR));

    contatos.add(new Contato(
        nome: 'Jessé da Silva',
        telefone: '(11)918237465',
        tipo: ContatoType.TRABALHO));

    contatos.add(new Contato(
        nome: 'Mãe', telefone: '(11)9522324342', tipo: ContatoType.CASA));

    contatos.add(new Contato(
        nome: 'João Casalli',
        telefone: '(66)95564352',
        tipo: ContatoType.FAVORITO));

    contatos.add(new Contato(
        nome: 'Vitor Borelli',
        telefone: '(13)945632414',
        tipo: ContatoType.TRABALHO));

    contatos.add(new Contato(
        nome: 'Edwin Portella',
        telefone: '(13)95928928',
        tipo: ContatoType.CASA));

    contatos.sort((a, b) => a.nome.compareTo(b.nome));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: ListView.separated(
            itemBuilder: (context, index) {
              var contato = contatos[index];
              return ListTile(
                leading: CircleAvatar(
                    child: ContatoHelper.getIconByContatoType(contato.tipo),
                    backgroundColor: Colors.blue[200]),
                title: Text(contato.nome),
                subtitle: Text(contato.telefone),
                trailing: IconButton(
                  icon: Icon(Icons.call),
                  onPressed: () => {},
                ),
              );
            },
            separatorBuilder: (context, index) => Divider(),
            itemCount: contatos.length));
  }
}

class Contato {
  final String nome;
  final String telefone;
  final ContatoType tipo;

  Contato({required this.nome, required this.telefone, required this.tipo});
}

enum ContatoType { CELULAR, TRABALHO, CASA, FAVORITO }

class ContatoHelper {
  static Icon getIconByContatoType(ContatoType tipo) {
    switch (tipo) {
      case ContatoType.CELULAR:
        return Icon(Icons.phone_android, color: Colors.green[700]);
      case ContatoType.TRABALHO:
        return Icon(Icons.work, color: Colors.brown[600]);
      case ContatoType.FAVORITO:
        return Icon(Icons.star, color: Colors.yellow[600]);
      case ContatoType.CASA:
        return Icon(Icons.home, color: Colors.purple[600]);
      default:
        return Icon(Icons.person, color: Colors.blue[600]);
    }
  }
}
