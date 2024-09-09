# Conexão com o Banco de Dados em Java

Criar uma aplicação em Java com o nome `Agenda`

1. Abrir o MySQL Workbench e criar um banco de dados chamado `agenda`

#### Script do Banco:

```Sql
CREATE database agenda;
USE `agenda` ;

CREATE TABLE IF NOT EXISTS `cadastro` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(45) NULL DEFAULT NULL,
 `email` VARCHAR(45) NULL DEFAULT NULL,
 `telefone` VARCHAR(45) NULL DEFAULT NULL,
 PRIMARY KEY (`id`)
);

```

1. Adicione um dado na tabela `cadastro`para testar

```Sql
USE `agenda` ;

INSERT INTO `cadastro` (`nome`, `email`, `telefone`) VALUES
('Lucas Silva', 'lucas.silva@example.com', '(11) 98765-4321');
```

### Instalação do driver `JDBC` 

O JDBC é um driver para conexão do java com o banco de dados (nesse contexto o banco é o MySql, mas poderiam ser outros)

Clique [aqui](https://dev.mysql.com/downloads/connector/j/) para baixar o MySql JDBC

1. Dentro do site, acesso "Archives" 
2. Product Version: << versão 8.4.0 >> e Operating System:<< Platform Independent >>
3. Baixe o arquivo .zip `Platform Independent (Architecture Independent), ZIP Archive`

OBS: A versão 8.4.0 já está nesse repositório, basta baixá-la caso queira usar essa versão!

### Configurando o NetBens para a Conexão

1. Com a sua aplicação java aberta, clique na aba `Serviços`, depois em `DataBases`

2. Com o botão direito em `DataBases` e depois em `New Connection`

3. Agora encontre o arquivo `mysql-connector-j-8.4.0.jar` dentro da pasta que você extraiu, confirme os dados da sua conexão.

### Exemplo:
```
Host: localhost
Port: 3306
Database: agenda
User Name: root
Password: root
```

### Classe de Conexão com o Banco
1. Volte para a aba `Projects` e crie uma classe chamada `BancoDeDados` na  sua aplicação java

OBS: Adicione alguns 'import' na sua classe

```Java
import java.sql.DriverManager;;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
```

2. Crie  o método void `conectar()`

```Java
public class BancoDeDados {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;
    
    public void conectar(){
        String servidor = "jdbc:mysql://localhost:3306/agenda";
        String usuario = "root";
        String senha = "root";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        //o driver faz a comunicação entre o java e o mysql ou outros bancos
        
        try{
            Class.forName(driver);
            this.connection = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.connection.createStatement();
            System.out.println("Conectou com sucesso!");
        }catch(Exception e){
            System.out.println("Paia!");
            System.out.println("Erro" + e.getMessage());
        }
    }
}
```
OBS: Adicione o driver nas Bibliotecas da sua aplicação, basta clicar com o botão direito em `Bibliotecas` depois em `adicionar JAR/Pasta ` e adicionar o driver que extraímos.

Utilizamos um TRY and CATCH para fazer a conexão da classe, para em casos de erro,  corrigirmos as excessões

2. Crie  o método void `desconectar()`
```Java
public void desconectar(){
        try{
            this.connection.close();
            System.out.println("Desconectou com sucesso!!");
        }catch(Exception e){
            System.out.println("Paia!");
            System.out.println("Erro" + e.getMessage());
        }
    }
```
3. Crie  os métodos void `inserir()` e `inseriratrib()`

```Java
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
```

4. Crie  o método void `apagar()`
```Java
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
```

5. Crie  o método void `alterar()`
```Java
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
```

6. Crie  o método void `listar()`
```Java
public void listar(String id) {
        try {
            String query = "SELECT * FROM cadastro WHERE `id` = "+id+" ORDER BY id ASC";
            this.resultset = this.statement.executeQuery(query);
            while(this.resultset.next()){
                System.out.println("ID: " + this.resultset.getString("id") + " - NOME: " + this.resultset.getString("nome") + " - EMAIL: " + this.resultset.getString("email") + " - TELEFONE: " + this.resultset.getString("telefone"));
            }
        } catch (Exception e){
            System.out.println("Paia a listagem!");
            System.err.println("Erro: " + e.getMessage());
        }
    }
```

### Testando os métodos

1. Na Classe `Agenda.java` adicione as linhas conforme o uso dos métodos:

```Java
public class Agenda {

public static void main(String[] args) {
        BancoDeDados bancodedados = new BancoDeDados();
        bancodedados.conectar();
        //bancodedados.inserir();// adicionar essa linha no objeto main da classe "Agenda"
        //aqui coloca a linha         
        //"bancodedados.desconectar();" se colocar antes de inserir, vai dar erro
        //bancodedados.inseriratrib("Paçoca", "pac@uol.com.br", "1140028922");
        //bancodedados.apagar("4");
        //bancodedados.alterar("Juvenales", "","", "5");
        //bancodedados.listar("9");
        bancodedados.desconectar();
    }
}
```

OBS: bastas remover os '//' da linha que deseja utilizar.






