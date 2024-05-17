import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        Usuarios.adicionarUsuario(12345, "senha123");
        Usuarios.adicionarUsuario(67890, "senha456");

        int matricula;
        System.out.println("Insira a matrícula:");
        matricula = sc.nextInt();
        sc.nextLine(); 

        String senha;
        System.out.println("Insira a senha:");
        senha = sc.nextLine();
        
        Login login = new Login();
        login.inserirMatricula(matricula);
        login.inserirSenha(senha);
        login.efetuarLogin(); 

        sc.close();
    }
}