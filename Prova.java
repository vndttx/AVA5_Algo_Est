import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Prova {
    private String nomeProva;
    private String data;
    private String hora;
    private String local;
    private int quilometragem;
    private int totalVagas;
    private List<Participante> participantesInscritos;

    public Prova(String nomeProva, String data, String hora, String local, int quilometragem, int totalVagas) {
        this.nomeProva = nomeProva;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.quilometragem = quilometragem;
        this.totalVagas = totalVagas;
        this.participantesInscritos = new ArrayList<>();
    }

    public String getNomeProva() {
        return nomeProva;
    }

    public void adicionarParticipante(Participante participante) {
        this.participantesInscritos.add(participante);
    }

    public int getVagasDisponiveis() {
        return totalVagas - participantesInscritos.size();
    }

    public void removerParticipante(Participante participante) {
        this.participantesInscritos.remove(participante);
    }

    public void exibirInformacoes() {
        System.out.println("\n--- Informações da Prova ---");
        System.out.println("Nome: " + nomeProva);
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
        System.out.println("Local de partida: " + local);
        System.out.println("Quilometragem: " + quilometragem + " Km");
        System.out.println("Total de Vagas: " + totalVagas);
        System.out.println("Vagas Disponiveis: " + getVagasDisponiveis());
        System.out.println("Número de Participantes Inscritos: " + participantesInscritos.size());

        System.out.println("\n--- Participantes Inscritos ---");
        if (participantesInscritos.isEmpty()) {
            System.out.println("Nenhum participante inscrito ainda.");
        } else {
            for (Participante p : participantesInscritos) {
                p.mostrarParticipante();
            }
        }
    }
}