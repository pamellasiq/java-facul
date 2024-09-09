/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenda;
//import java.sql.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
/**
 *
 * @author Pâmella
 */
public class BancoDeDados {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;
    
    public void conectar() {
        Properties config = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            config.load(fis);
            String servidor = config.getProperty("db.url");
            String usuario = config.getProperty("db.user");
            String senha = config.getProperty("db.password");
            String driver = config.getProperty("db.driver");

            Class.forName(driver);
            this.connection = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.connection.createStatement();
            System.out.println("Conectou com sucesso!");
        } catch (Exception e) {
            System.out.println("Paia!");
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void desconectar(){
        try{
            this.connection.close();
            System.out.println("Desconectou com sucesso!!");
        }catch(Exception e){
            System.out.println("Paia!");
            System.out.println("Erro" + e.getMessage());
        }
    }
    
    public void inserir(){
        try{
            String query = "INSERT INTO `agenda`.`cadastro` (`nome`, `email`, `telefone`) VALUES ('Joãozin', 'joj@uol.com.br', '14997990009');" ;
            System.out.println(query);
            this.statement.execute(query);
            System.out.println("Registro inserido com sucesso!!!");
        }catch(Exception e){
            System.out.println("Paia na inserção!");
            System.out.println("Erro" + e.getMessage());
            
        }
    }
    
    public void inseriratrib(String nome, String email, String telefone){
        try{
            String query = "INSERT INTO `agenda`.`cadastro` (`nome`, `email`, `telefone`) VALUES ('"+ nome +"', '"+ email +"', '"+ telefone +"');" ;
            System.out.println(query);
            this.statement.execute(query);
            System.out.println("Registro inserido com sucesso!!!");
        }catch(Exception e){
            System.out.println("Paia na inserção!");
            System.out.println("Erro" + e.getMessage());
            
        }
    }
    
    public void apagar(String id){
        try{
            String query = " DELETE FROM `agenda`.`cadastro` WHERE (`id` = '"+id+"');" ;
            System.out.println(query);
            this.statement.execute(query);
            System.out.println("Registro inserido com sucesso!!!");
        }catch(Exception e){
            System.out.println("Paia na inserção!");
            System.out.println("Erro" + e.getMessage());
            
        }
        
        
    }
    
    public void alterar(String id, String nome, String email, String telefone){
        try{
            String query = "UPDATE `agenda`.`cadastro` SET `nome` = '"+nome+"', `email` = '"+email+"', `telefone` = '"+telefone+"' WHERE (`id` = '"+id+"');" ;
            System.out.println(query);
            this.statement.execute(query);
            System.out.println("Registro inserido com sucesso!!!");
        }catch(Exception e){
            System.out.println("Paia na alteração!");
            System.out.println("Erro" + e.getMessage());
            
        }

        
    }
    
    public void listar(String id) {
        try {
            String query = "SELECT * FROM cadastro WHERE `id` = "+id+" ORDER BY id ASC";
            this.resultset = this.statement.executeQuery(query);
            while(this.resultset.next()){
                System.out.println(query); //para mostrar a query e ter certeza do que está recebendo
                System.out.println("ID: " + this.resultset.getString("id") + " - NOME: " + this.resultset.getString("nome") + " - EMAIL: " + this.resultset.getString("email") + " - TELEFONE: " + this.resultset.getString("telefone"));
            }
        } catch (Exception e){
            System.out.println("Paia a listagem!");
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

