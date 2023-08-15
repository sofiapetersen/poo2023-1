/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopratico1;

import java.util.Scanner;
import java.util.List;

/**
 *
 * @author sofiapetersen
 */
public class TrabalhoPratico1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BlocoDeLembretes bloco = new BlocoDeLembretes();

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        Lembretes note = new Lembretes("", 0, 0, 0);

        while (opcao != 7) {
            opcao = note.menu();

            switch (opcao) {
                case 1:
                    scanner.nextLine();     //talvez precise dar um enter pra aparecer a proxima linha
                    System.out.print("Digite o lembrete: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Dia: ");
                    int dia = scanner.nextInt();
                    System.out.print("Mes: ");
                    int mes = scanner.nextInt();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    bloco.inserir(descricao, dia, mes, ano);
                    break;
                case 2:
                    System.out.print("Indice pra ser removido: ");
                    int indice = scanner.nextInt();
                    bloco.remover(indice);
                    break;
                case 3:
                    bloco.ordenar();
                    System.out.print("Informe o mes pra buscar: ");
                    int mesBusca = scanner.nextInt();
                    List<Lembretes> lembretesDoMes = bloco.buscarMes(mesBusca);
                    if (!lembretesDoMes.isEmpty()) {
                        System.out.println("Lembretes encontrados do mes " + mesBusca + ":");
                            for (Lembretes lembrete : lembretesDoMes) {
                                System.out.println(lembrete);
                            }
                    } else {
                        System.out.println("Nenhum lembrete no mes " + mesBusca);
                    }
                    break;
                case 4:
                    bloco.ordenar();
                    System.out.print("Informe o dia pra buscar: ");
                    int diaBusca = scanner.nextInt();
                    List<Lembretes> lembretesDoDia = bloco.buscarDia(diaBusca);
                    if (!lembretesDoDia.isEmpty()) {
                        System.out.println("Lembretes encontrados do dia " + diaBusca + ":");
                            for (Lembretes lembrete : lembretesDoDia) {
                                System.out.println(lembrete);
                            }
                    } else {
                        System.out.println("Nenhum lembrete no dia " + diaBusca);
                    }
                    break;
                case 5:
                    bloco.ordenar();
                    bloco.imprimir();
                    break;
                case 6:
                    scanner.nextLine();         //talvez precise dar um enter pra aparecer a proxima linha
                    System.out.print("Informe a substring pra buscar: ");
                    String substring = scanner.nextLine();
                    List<Lembretes> lembretesEncontrados = bloco.buscarSubstring(substring);
                    if (!lembretesEncontrados.isEmpty()) {
                        System.out.println("Lembretes encontrados:");
                            for (Lembretes lembrete : lembretesEncontrados) {
                                System.out.println(lembrete);
                            }
                    } else {
                         System.out.println("Nenhum lembrete encontrado");
                    }
                    break;
                case 7:
                    System.out.println("Fechando a agenda");
                 break;
            }
        }
        
        bloco.ordenar();

        scanner.close();
    }
}