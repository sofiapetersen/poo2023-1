/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author User
 */
public class Exercicio1 {

        private String nome;
    private Data nascimento;
    private float altura;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    /**
     * @return the nascimento
     */
    public Data getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Data nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }
    

    public int calcularIdade(){
        LocalDate atual = LocalDate.now();
        LocalDate dataNascimento = this.nascimento.toLocalDate();
        
        Period periodo = Period.between(dataNascimento, atual);
        System.out.println("|| " + atual + " ||");
        return periodo.getYears();
    }
    
    public void imprimir(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + this.nascimento.dia + "/" + this.nascimento.mes + "/" + this.nascimento.ano);
        System.out.println("Altura: " + this.altura);
        
}
    
  public static void main(String[] args){
      
      Data dataNascimento = new Data(21, 02, 2003);
      pessoa p1 = new pessoa();
      p1.setNome("Sofia");
      p1.setNascimento(dataNascimento);
      p1.setAltura(1.68f);
      int idade = p1.calcularIdade();
      p1.imprimir();
      System.out.println("Idade: " + idade);
  }
    
    
}
