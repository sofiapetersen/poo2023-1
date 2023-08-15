/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zaffari;

/**
 *
 * @author User
 */
public class Zaffari {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcionario supervisor = new Supervisor(1105, 5000);
        Funcionario caixa = new Caixa(2000);
        Funcionario e = new Estocadista(1500);
        
        Autenticavel a = (Autenticavel) supervisor;
        
        System.out.println("Autenticando supervisor... ");
        if(a.autenticar(1106)){
            System.out.println("Supervisor autenticado!");
            System.out.println(supervisor);
            System.out.println(caixa);
            System.out.println(e);
        }
            else{
            System.out.println("Senha incorreta!\nNao foi possivel acessar os dados.");
        }
           
    }
    
}
