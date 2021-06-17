import 'package:brasil_fields/brasil_fields.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:form_field_validator/form_field_validator.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Contato Form',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Contato Form'),
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
  ContatoModel contato = new ContatoModel();
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(contato.nome ?? ''),
        ),
        body: Form(
          key: _formKey,
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Wrap(
              spacing: 20,
              runSpacing: 10,
              children: <Widget>[
                TextFormField(
                  validator: nomeValidator(),
                  onChanged: updateNome,
                  decoration: InputDecoration(labelText: "Nome"),
                  maxLength: 100,
                ),
                TextFormField(
                  inputFormatters: [
                    FilteringTextInputFormatter.digitsOnly,
                    TelefoneInputFormatter()
                  ],
                  onChanged: updateTelefone,
                  keyboardType: TextInputType.number,
                  decoration: InputDecoration(labelText: "Telefone"),
                ),
                TextFormField(
                  validator: emailValidator(),
                  onChanged: updateEmail,
                  decoration: InputDecoration(labelText: "Email"),
                ),
                TextFormField(
                  inputFormatters: [
                    FilteringTextInputFormatter.digitsOnly,
                    CpfInputFormatter()
                  ],
                  onChanged: updateCpf,
                  keyboardType: TextInputType.number,
                  decoration: InputDecoration(labelText: "CPF"),
                ),
                ElevatedButton(
                    onPressed: () {
                      if (_formKey.currentState!.validate()) {
                        print(contato);
                      }
                    },
                    child: Text('Salvar'))
              ],
            ),
          ),
        ));
  }

  void updateNome(nome) {
    setState(() {
      contato.nome = nome;
    });
  }

  void updateTelefone(telefone) => contato.telefone = telefone;
  void updateEmail(email) => contato.email = email;
  void updateCpf(cpf) => contato.cpf = cpf;

  TextFieldValidator emailValidator() {
    return EmailValidator(errorText: 'email inválido');
  }

  FieldValidator nomeValidator() {
    return MultiValidator([
      RequiredValidator(errorText: 'campo obrigatório'),
      MinLengthValidator(4, errorText: 'tamanho mínimo de 4 caracteres')
    ]);
  }
}

class ContatoModel {
  String? nome;
  String? email;
  String? telefone;
  String? cpf;
  ContatoType? tipo;
}

enum ContatoType { CELULAR, TRABALHO, CASA, FAVORITO }
