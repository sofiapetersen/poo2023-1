/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio4;

/**
 *
 * @author User
 */
public class Data {
    private int dia;
    private int mes;
    private int ano;
    private static final String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
    
    public void data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    @Override
    public String toString(){
        return (dia < 10 ? "0" + dia : dia) + "/" + (mes <10 ? "0"+ mes : mes) + "/" + (ano <10 ? "0"+ano : ano);
    }
    
    public String extenso(){
        return (dia < 10 ? "0"+ dia : dia) + "de " + (nomeMes(mes)) + "de " + 
    }
    
    public static String nomeMes(int mes){
        if(mes > 0 && mes <13)
            return meses[mes-1];
        
    }
}


