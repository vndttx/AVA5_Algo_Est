import java.util.ArrayList;
import java.util.List;

class Prova {
    private String nomeProva;
    private String dataProva;
    private String horaPartida;
    private String localPartida;
    private int quilometragem;
    private int totalVagas;
    private List<Participante> totalInscritos;

    public Prova(String provaNome, String provaData, String provaHora, String provaLocal, int provaKm, int provaVagas) {
        this.nomeProva = provaNome;
        this.dataProva = provaData;
        this.horaPartida = provaHora;
        this.localPartida = provaLocal;
        this.quilometragem = provaKm;
        this.totalVagas = provaVagas;
        this.totalInscritos = new ArrayList();
    }

    public String getNomeProva() {
        return this.nomeProva;
    }

    public void realizarInscricao(Participante participanteNome) {
        if (this.totalInscritos.size() < this.totalVagas) {
            this.totalInscritos.add(participanteNome);
            System.out.println("Reserva realizada com sucesso para " + participanteNome.getNome());
        } else {
            System.out.println("Não há lugares disponiveis para esta prova.");
        }

    }

    public void exibirInformacoes() {
        System.out.println("\n=== Informacoes da Prova ===");
        System.out.println("Nome da Prova: " + this.nomeProva);
        System.out.println("Data e hora da corrida: " + this.dataProva + " às " + this.horaPartida);
        System.out.println("Local de partida: " + this.localPartida);
        System.out.println("Quilometragem da prova: " + this.quilometragem);
        System.out.println("Total de participantes: " + this.totalInscritos.size());
        int var10001 = this.totalVagas;
        System.out.println("Vagas Disponíveis: " + (var10001 - this.totalInscritos.size()));
    }
}

