/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopratico1;

import java.time.LocalDate;

/**
 *
 * @author sofiapetersen
 */
public class Data {
    private final int dia;
    private final int mes;
    private final int ano;
    private static final String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
    
    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getMes() {
        return mes;
    }
    public int getDia() {
        return dia;
    }
    
    public int ano() {
        return ano;
    }
    @Override
    public String toString(){
        return (dia < 10 ? "0"+dia : dia) + "/" + (mes < 10 ? "0"+mes : mes) + "/" + ano;
    }
    
    public String extenso(){
        return ((dia<10 ? "0"+dia : dia) + "de " + nomeMes(mes) + "de " + ano);
    }
    
    public static String nomeMes(int mes){
        if(mes > 0 && mes <13)
            return meses[mes-1];
        return null;
        
    }
    
    public int CalcularIdade(){
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - ano;
        if(dataAtual.getMonthValue() < mes){
            idade--;
        }
        else if(dataAtual.getDayOfMonth() == mes && dataAtual.getDayOfMonth() < dia){
            idade--;
        }
        return idade;
    }
    
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(o instanceof Data outraData){
            if(this.ano == outraData.ano && this.mes == outraData.mes && this.ano == outraData.ano);{
            return true;
            }
        }
        return false;
    }
    
    public LocalDate toLocalDate(){
        return LocalDate.of(this.ano, this.mes, this.dia);
    }
    
    public int compareTo(Data outra) {
        if (this.ano < outra.ano) {
            return -1;
        } else if (this.ano > outra.ano) {
            return 1;
        } else {
            if (this.mes < outra.mes) {
                return -1;
            } else if (this.mes > outra.mes) {
                return 1;
            } else {
                return Integer.compare(this.dia, outra.dia);
            }
        }
    }
    
}
