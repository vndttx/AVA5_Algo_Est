import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] listaDeProvas) {
        Scanner scanner = new Scanner(System.in);
        ArrayList dadosProva = new ArrayList();
        ArrayList dadosParticipante = new ArrayList();
        int opcaoEscolhida;
        do {
            System.out.println("\n=== SISTEMA DE RESERVA PARA CORREDORES ===");
            System.out.println("1 - Cadastrar Prova");
            System.out.println("2 - Realizar sua Inscrição");
            System.out.println("3 - Consultar Informacoes da Prova");
            System.out.println("4 - Consultar Informacoes de um Participante");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoEscolhida) {
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                case 1:
                    System.out.print("Nome da Prova: ");
                    String provaNome = scanner.nextLine();
                    System.out.print("Data da prova: ");
                    String provaData = scanner.nextLine();
                    System.out.print("Hora da prova: ");
                    String provaHora = scanner.nextLine();
                    System.out.print("Local de partida: ");
                    String provaLocal = scanner.nextLine();
                    System.out.println("Quilometragem da prova: ");
                    int provaKm = scanner.nextInt();
                    System.out.print("Numero Total de Vagas: ");
                    int provaVagas = scanner.nextInt();
                    scanner.nextLine();
                    dadosProva.add(new Prova(provaNome, provaData, provaHora, provaLocal, provaKm, provaVagas));
                    System.out.println("Prova cadastrada com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome da Prova: ");
                    String provaBuscada1 = scanner.nextLine();
                    Prova provaInserida = buscarProva(dadosProva, provaBuscada1);
                    if (provaInserida != null) {
                        System.out.print("Nome do participante: ");
                        String participanteNome = scanner.nextLine();
                        System.out.print("CPF (apenas numeros): ");
                        String participanteCPF = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String participanteTelefone = scanner.nextLine();
                        dadosParticipante.add(new Participante(participanteNome, participanteCPF, participanteTelefone));
                        System.out.println("Cadastro realizado com sucesso.");
                    } else {
                        System.out.println("Prova não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Nome da Prova: ");
                    String provaBuscada2 = scanner.nextLine();
                    Prova provaBuscar = buscarProva(dadosProva, provaBuscada2);
                    if (provaBuscar != null) {
                        provaBuscar.exibirInformacoes();
                    } else {
                        System.out.println("Prova não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("CPF (apenas numeros): ");
                    String cpfBuscado = scanner.nextLine();
                    Participante cpfBuscar = buscarParticipante(dadosParticipante, cpfBuscado);
                    if (cpfBuscar != null) {
                        cpfBuscar.mostrarParticipante();
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(opcaoEscolhida != 0);

        scanner.close();
    }
    //puxa o metodo buscarProva da classe Prova
    private static Prova buscarProva(List<Prova> provaList, String provaNome) {
        for(Prova provaAtual : provaList) {
            if (provaAtual.getNomeProva().equals(provaNome)) {
                return provaAtual;
            }
        }

        return null;
    }
    //puxa o metodo buscarParticipante da classe Participante
    private static Participante buscarParticipante(List<Participante> participanteList, String cpfBuscado) {
        for(Participante participanteAtual : participanteList) {
            if (participanteAtual.getCPF().equals(cpfBuscado)) {
                return participanteAtual;
            }
        }

          return null;
    }
}
