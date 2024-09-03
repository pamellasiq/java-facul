// Source code is decompiled from a .class file using FernFlower decompiler.
package com.mycompany.agenda;

public class Agenda {
   public Agenda() {
   }

   public static void main(String[] args) {
      BancoDeDados bancodedados = new BancoDeDados();
      bancodedados.conectar();
      bancodedados.listar();
      bancodedados.desconectar();
   }
}

