/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio2;


public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Elevador e = new Elevador();
        
        e.inicializa(6, 10);
        //System.out.println("Andar: " + e.andarAtual); nao funciona pq eh privado, tem que criar uma public void la no elevador
        e.imprimir();
        e.entrar();
        e.entrar();
        e.imprimir();
        e.subir();
        e.subir();
        e.imprimir();
        e.entrar();
        e.imprimir();
        e.subir();
        e.subir();
        e.imprimir();
        e.sair();
        e.imprimir();
        e.descer();
        e.descer();
        e.descer();
        e.descer();
        e.imprimir();
        
        
        
             
    }
    
}
