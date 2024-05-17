public class Login {
    private int inserirMatricula;
    private String inserirSenha;

    public void inserirMatricula(int inserirMatricula) {
        this.inserirMatricula = inserirMatricula;
    }

    public void inserirSenha(String inserirSenha) {
        this.inserirSenha = inserirSenha;
    }

    public boolean efetuarLogin() {
        Usuarios usuario = Usuarios.buscarUsuarioPorMatricula(inserirMatricula);
        if (usuario == null) {
            System.out.println("Matrícula não cadastrada.");
            return false;
        }
        if (!usuario.getSenha().equals(inserirSenha)) {
            System.out.println("Senha incorreta.");
            return false;
        }
        System.out.println("Login bem-sucedido.");
        return true;
    }
}