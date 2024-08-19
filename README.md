# Prog1 tutorial

1. Criar arquitetura de pastas na `C:\\` (para uso pessoal) ou na faculdade, crie em `C:\\Users\{seu RA}\Desktop`
```
│▸ Java
    ┗ ▸  prog1
      ▸  prog2
```

3. Criar um arquivo `Sobre.txt`
```
│▸ Java
    ┗ ▸  prog1
         ┗ ▸Sobre.txt
      ▸  prog2
```

5. Criar um arquivo `PrimeiraClasse.java`
```java
/**
*Minha Classe
*/

public class PrimeiraClasse{
	public static void main(String[] args){
	System.out.println("Hello World!!!");
	}
}
```
5. Navegue até o diretorio pelo terminal  `cd C:\Program Files\Java\jdk-17\bin`
6. Coloque o comando `javac C:\Java\prog1\PrimeiraClasse.java`
7. Depois use `cd/` para sair da pasta bin e vá para o local da sua classe,
```sh
cd C:\Java\prog1\
```
8. Agora use o comando `java PrimeiraClasse`

9. Por fim, seu arquivo será executado dessa forma:

```sh
C:\Java\prog1>java PrimeiraClasse
Hello World!!!
```

## Anotações:
CLI - Uma interface de linha de comando (CLI) é uma interface baseada em texto na qual você pode inserir comandos que interagem com o sistema operacional de um computador.

GUI - Uma interface gráfica do usuário (GUI na sigla em inglês) é um sistema que interage com o usuário visualmente. A GUI inclui coisas como menus, ícones para programas e aplicativos e janelas de navegadores.

TUI - O NetworkManager faz uma seleção oportunista da rede, tentando usar a melhor conexão disponível quando ocorre uma falha ou quando o usuário move-se de uma rede para outra.