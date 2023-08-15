/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zaffari;

/**
 *
 * @author sofia
 */
public class Supervisor extends Funcionario implements Autenticavel {
    private int senha;
    
    public Supervisor(int senha, double salario){
        super(salario);
        this.senha = senha;
    }
    
    @Override
    public boolean autenticar(int senha){
        if(this.senha == senha){
            return true;
        }
        else{
        return false;
        }
    }
    
    @Override
    public String toString(){
        return "Salario Supervisor: " + super.toString();
    }
}
