/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zaffari;

/**
 *
 * @author sofia
 */
public class Caixa extends Funcionario{
    //private int item;
    
    public Caixa (double salario){
        super(salario);
    }
    
    public void RemoveItem(){
        System.out.println("ainda nao implementei");
}
    @Override
    public String toString(){
        return "Salario Caixa: " + super.toString();
    }
    
}
