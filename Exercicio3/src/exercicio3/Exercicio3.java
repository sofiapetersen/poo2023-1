/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio3;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Televisao tv = new Televisao();
        
        Controle controleRemoto = new Controle(tv);
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;
        
        while (opcao !=6){
            menu();
            System.out.print("Aperte o botao: ");
            opcao = scanner.nextInt();
            
            switch(opcao){
                case 1:
                    controleRemoto.aumentarVolume();
                    controleRemoto.info();
                    break;
                case 2:    
                    controleRemoto.diminuirVolume();
                    controleRemoto.info();
                    break;
                case 3:
                    controleRemoto.proximoCanal();
                    controleRemoto.info();
                    break;
                case 4:
                    controleRemoto.previousCanal();
                    controleRemoto.info();
                    break;
                case 5:
                    System.out.print("Digite o canal: ");
                    int canal = scanner.nextInt();
                    controleRemoto.escolherCanal(canal);
                    controleRemoto.info();
                    break;
                case 6:
                    System.out.println("Desligando a TV...");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    System.out.println("");
                    break;
            }
        }
        
    }
    
    public static void menu(){
        System.out.println("---CONTROLE REMOTO---");
        System.out.println("1- Aumentar volume");
        System.out.println("2- Diminuir volume");
        System.out.println("3- Proximo canal");
        System.out.println("4- Canal anterior");
        System.out.println("5- Escolher canal");
        System.out.println("6- Desligar televisao");
        
         
    }
    
}
