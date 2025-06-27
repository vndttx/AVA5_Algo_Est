import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] listaDeProvas) {
        Scanner scanner = new Scanner(System.in);
        List<Prova> dadosProva = new ArrayList<>();
        List<Participante> dadosParticipantes = new ArrayList<>();
        int opcaoEscolhida;

        do {
            System.out.println("\n=== SISTEMA DE RESERVA PARA CORREDORES ===");
            System.out.println("1 - Cadastrar Prova");
            System.out.println("2 - Cadastrar Participante");
            System.out.println("3 - Consultar Informacoes da Prova");
            System.out.println("4 - Consultar Informacoes de um Participante");
            System.out.println("5 - Remover um Participante");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcaoEscolhida = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, digite um número.");
                scanner.nextLine();
                opcaoEscolhida = -1;
                continue;
            }

            switch (opcaoEscolhida) {
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                case 1:
                    System.out.print("Nome da Prova: ");
                    String provaNome = scanner.nextLine();
                    System.out.print("Data da prova (dd/mm/aaaa): ");
                    String provaData = scanner.nextLine();
                    System.out.print("Hora da prova (hh:mm): ");
                    String provaHora = scanner.nextLine();
                    System.out.print("Local de partida: ");
                    String provaLocal = scanner.nextLine();
                    int provaKm;
                    while (true) {
                        try {
                            System.out.print("Quilometragem da prova: ");
                            provaKm = scanner.nextInt();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, digite um número inteiro para a quilometragem.");
                            scanner.nextLine();
                        }
                    }

                    int provaVagas;
                    while (true) {
                        try {
                            System.out.print("Numero Total de Vagas: ");
                            provaVagas = scanner.nextInt();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, digite um número inteiro para as vagas.");
                            scanner.nextLine();
                        }
                    }

                    scanner.nextLine();

                    dadosProva.add(new Prova(provaNome, provaData, provaHora, provaLocal, provaKm, provaVagas));
                    System.out.println("Prova cadastrada com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome da Prova: ");
                    String provaBuscada1 = scanner.nextLine();
                    Prova provaParaInscricao = buscarProva(dadosProva, provaBuscada1);

                    if (provaParaInscricao != null) {
                        if (provaParaInscricao.getVagasDisponiveis() > 0) {
                            System.out.print("Nome do participante: ");
                            String participanteNome = scanner.nextLine();
                            System.out.print("CPF (apenas numeros): ");
                            String participanteCPF = scanner.nextLine();
                            System.out.print("Telefone: ");
                            String participanteTelefone = scanner.nextLine();

                            Participante novoParticipante = new Participante(participanteNome, participanteCPF, participanteTelefone);
                            provaParaInscricao.adicionarParticipante(novoParticipante);
                            dadosParticipantes.add(novoParticipante);

                            System.out.println("Cadastro realizado com sucesso.");
                        } else {
                            System.out.println("Não há vagas disponíveis para esta prova.");
                        }
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
                    Participante cpfBuscar = buscarParticipante(dadosParticipantes, cpfBuscado);
                    if (cpfBuscar != null) {
                        cpfBuscar.mostrarParticipante();
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                //entender pq está mostrando o case 5 junto
                case 5:
                    System.out.print("CPF do participante a ser removido (apenas numeros): ");
                    String cpfParaRemover = scanner.nextLine();

                    Participante participanteParaRemover = buscarParticipante(dadosParticipantes, cpfParaRemover);

                    if (participanteParaRemover != null) {
                        dadosParticipantes.remove(participanteParaRemover);
                        System.out.println("Participante removido da lista principal.");
                        for (Prova prova : dadosProva) {
                            prova.removerParticipante(participanteParaRemover);
                        }
                        System.out.println("O participante também foi removido de todas as provas em que estava inscrito.");
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoEscolhida != 0);

        scanner.close();
    }
    private static Prova buscarProva(List<Prova> provaList, String provaNome) {
        for (Prova provaAtual : provaList) {
            if (provaAtual.getNomeProva().equalsIgnoreCase(provaNome.trim())) {
                return provaAtual;
            }
        }
        return null;
    }
    private static Participante buscarParticipante(List<Participante> participanteList, String cpfBuscado) {
        for (Participante participanteAtual : participanteList) {
            if (participanteAtual.getCPF().equals(cpfBuscado)) {
                return participanteAtual;
            }
        }
        return null;
    }
}