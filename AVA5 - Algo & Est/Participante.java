import java.util.ArrayList;
import java.util.List;

class Participante {
    private String nome;
    private String cpf;
    private String telefone;

    public Participante(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCPF() {
        return cpf;
    }

    public void mostrarParticipante() {
        System.out.println("Nome: " + this.nome + ", CPF: " + this.cpf + ", Telefone: " + this.telefone);
    }
}
