import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        ArrayList var2 = new ArrayList();

        int var3;
        do {
            System.out.println("\n=== SISTEMA DE RESERVA PARA CORREDORES ===");
            System.out.println("1 - Cadastrar Prova");
            System.out.println("2 - Realizar inscrição");
            System.out.println("3 - Consultar Informações da Prova");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            var3 = var1.nextInt();
            var1.nextLine();
            switch (var3) {
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                case 1:
                    System.out.print("Nome da Prova: ");
                    String var4 = var1.nextLine();
                    System.out.print("Data da prova: ");
                    String var5 = var1.nextLine();
                    System.out.print("Hora da prova: ");
                    String var6 = var1.nextLine();
                    System.out.print("Local de partida: ");
                    String var7 = var1.nextLine();
                    System.out.println("Quilometragem da prova: ");
                    int var8 = var1.nextInt();
                    System.out.print("Número Total de Vagas: ");
                    int var9 = var1.nextInt();
                    var1.nextLine();
                    var2.add(new Corrida(var4, var5, var6, var7, var8, var9));
                    System.out.println("Voo cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome da Prova: ");
                    String var10 = var1.nextLine();
                    Corrida var11 = buscarCorrida(var2, var10);
                    if (var11 != null) {
                        System.out.print("Nome do participante: ");
                        String var15 = var1.nextLine();
                        System.out.print("CPF: ");
                        String var16 = var1.nextLine();
                        System.out.print("Telefone: ");
                        String var13 = var1.nextLine();
                        Prova var14 = new Prova(var15, var16, var13);
                        var11.reservarLugar(var14);
                    } else {
                        System.out.println("Prova não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Nome da Prova: ");
                    String var12 = var1.nextLine();
                    Corrida var13 = buscarCorrida(var2, var12);
                    if (var13 != null) {
                        var13.exibirInformacoes();
                    } else {
                        System.out.println("Prova não encontrada.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }//meu case 4 vai ser a remoção de um participante, usando queue talvez
        } while(var3 != 0);

        var1.close();
    }

    private static Corrida buscarCorrida(List<Corrida> var0, String var1) {
        for(Corrida var3 : var0) {
            if (var3.getNomeCorrida().equals(var1)) {
                return var3;
            }
        }

        return null;
    }
}
