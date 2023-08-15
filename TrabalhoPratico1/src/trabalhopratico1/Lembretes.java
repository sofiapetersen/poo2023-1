/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopratico1;

import java.util.Scanner;


/**
 *
 * @author sofiapetersen
 */
public class Lembretes {
    
    private final String descricao;
    private final Data data;
    
    public Lembretes(String descricao, int dia, int mes, int ano) {
        this.descricao = descricao;
        this.data = new Data(dia, mes, ano);
        
    }
    
    @Override
    public String toString() {
        return data.toString() + " - " + descricao;
    }


    public boolean contemSubstring(String substring) {
        return descricao.contains(substring);
    }
    
    public Data getData() {
        return data;
    }
    
    public boolean buscaMes(int mes) {
        return this.data.getMes() == mes;
    }
    
    public boolean buscaDia(int dia) {
        return this.data.getDia() == dia;
    }
    
    public int compararPorData(Lembretes outro) {
        return this.data.compareTo(outro.data);
    }
    
    public int menu() {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n---- APLICATIVO DE AGENDA ----");
            System.out.println("1 - Adicionar Lembrete");
            System.out.println("2 - Excluir Lembrete");
            System.out.println("3 - Imprimir Lembretes do Mes");
            System.out.println("4 - Imprimir Lembretes do Dia");
            System.out.println("5 - Imprimir Todos os Lembretes");
            System.out.println("6 - Buscar por descricao");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();
        } while (opcao < 1 || opcao > 7);
        return opcao;
    } 
}




