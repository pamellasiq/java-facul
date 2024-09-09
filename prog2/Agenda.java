// Source code is decompiled from a .class file using FernFlower decompiler.
package com.mycompany.agenda;

public class Agenda {
   public Agenda() {
   }

   public static void main(String[] args) {
        BancoDeDados bancodedados = new BancoDeDados();
        bancodedados.conectar();
        //bancodedados.inserir();// adicionar essa linha no objeto main da classe "Agenda"
        //aqui coloca a linha         
        //"bancodedados.desconectar();" se colocar antes de inserir, vai dar erro
        //bancodedados.inseriratrib("Paçoca", "pac@uol.com.br", "1140028922");
        //bancodedados.apagar("4");
        //bancodedados.alterar("Juvenales", "","", "5");
        bancodedados.listar("9");
        bancodedados.desconectar();
    }
}

