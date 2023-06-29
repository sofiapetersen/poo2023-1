/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio2;

public class Elevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int pessoas;
    
    public void inicializa(int capacidade, int totalAndares){
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.pessoas = 0;
    }
    
    public void entrar(){
        if (pessoas < capacidade)
            pessoas++;
    }
    
    public void sair(){
        if(pessoas > 0)
            pessoas--;
    }
    
    public void subir(){
        if(andarAtual < totalAndares)
            andarAtual++;
    }
    
    public void descer(){
        if(andarAtual > 0)
            andarAtual--;
    }
    
    public void imprimir(){
        System.out.println("Total de andares: "+ this.totalAndares);
        System.out.println("Andar atual: "+ this.andarAtual);
        System.out.println("Pessoas: " + this.pessoas + "/" + this.capacidade);
        System.out.println(" ");
        
    }
}