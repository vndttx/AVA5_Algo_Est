import java.util.ArrayList;
import java.util.List;

class Participante {
    private String nome;
    private String CPF;
    private String telefone;

    public Participante(String participanteNome, String participanteCPF, String participanteTelefone) {
        this.nome = participanteNome;
        this.CPF = participanteCPF;
        this.telefone = participanteTelefone;
    }

    public String getNome() {
        return this.nome;
    }
    public String getCPF() {
        return this.CPF;
    }

    public void mostrarParticipante() {
        System.out.println("\n=== Informacoes do Participante requisitado ===");
        System.out.println("Nome do(a) participante: " + this.nome);
        System.out.println("CPF do(a) participante: " + this.CPF);
        System.out.println("Telefone do(a) participante: " + this.telefone);
    }
}
