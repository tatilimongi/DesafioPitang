import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private int matricula;
    private String senha;
    private static List<Usuarios> listaUsuarios = new ArrayList<>();

    public Usuarios(int matricula, String senha) {
        this.matricula = matricula;
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static void adicionarUsuario(int matricula, String senha) {
        listaUsuarios.add(new Usuarios(matricula, senha));
    }

    public static Usuarios buscarUsuarioPorMatricula(int matricula) {
        for (Usuarios usuario : listaUsuarios) {
            if (usuario.getMatricula() == matricula) {
                return usuario;
            }
        }
        return null; 
    }

    public static List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    
}