/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zaffari;

/**
 *
 * @author sofia
 */
public class Estocadista extends Funcionario {
    
    public Estocadista(double salario){
        super(salario);
    }
    
    @Override
    public String toString(){
        return "Salario Estocadista: " + super.toString();
    }
}
