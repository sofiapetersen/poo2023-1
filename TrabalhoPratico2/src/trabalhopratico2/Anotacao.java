/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopratico2;

import java.util.Scanner;


/**
 *
 * @author sofiapetersen
 */
public class Anotacao {
    
    private String titulo;
    private String descricao;
    private Data data;
    
    public Anotacao(String titulo, String descricao, int dia, int mes, int ano) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = new Data(dia, mes, ano);
        
    }
    
    public void setTitulo(String novoTitulo) {
        this.titulo = novoTitulo;
    }
    
    public void setData(int dia, int mes, int ano) {
        this.data.setData(dia, mes, ano);
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
    
    public int compararPorData(Anotacao outro) {
        return this.data.compareTo(outro.data);
    }
    
    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    
   
}




