import java.util.ArrayList;
import java.util.List;

class Corrida {
    private String nomeCorrida;
    private String dataProva;
    private String horaPartida;
    private String localPartida;
    private int quilometragem;
    private int totalVagas;
    private List<Prova> totalInscritos;

    public Corrida(String var1, String var2, String var3, String var4, int var5, int var6) {
        this.nomeCorrida = var1;
        this.dataProva = var2;
        this.horaPartida = var3;
        this.localPartida = var4;
        this.quilometragem = var5;
        this.totalVagas = var6;
        this.totalInscritos = new ArrayList();
    }

    public String getNomeCorrida() {
        return this.nomeCorrida;
    }

    public void reservarLugar(Prova var1) {
        if (this.totalInscritos.size() < this.totalVagas) {
            this.totalInscritos.add(var1);
            System.out.println("Reserva realizada com sucesso para " + var1.getNome());
        } else {
            System.out.println("Não há lugares disponiveis para esta prova.");
        }

    }

    public void exibirInformacoes() {
        System.out.println("\n=== Informacoes da Corrida ===");
        System.out.println("Nome da Corrida: " + this.nomeCorrida);
        System.out.println("Data e hora da corrida: " + this.dataProva + " às " + this.horaPartida);
        System.out.println("Local de partida: " + this.localPartida);
        System.out.println("Quilometragem da prova: " + this.quilometragem);
        System.out.println("Total de participantes: " + this.totalInscritos.size());
        int var10001 = this.totalVagas;
        System.out.println("Vagas Disponíveis: " + (var10001 - this.totalInscritos.size()));
    }
}

