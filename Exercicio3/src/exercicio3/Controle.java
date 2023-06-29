/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio3;

import java.util.Scanner;

public class Controle {
    private Televisao tv;
    
    public Controle(Televisao tv){
        this.tv = tv;
    }
    
    public void aumentarVolume(){
        tv.aumentarVol();
    }
    
    public void diminuirVolume(){
        tv.diminuirVol();
    }
    
    public void proximoCanal(){
        tv.proxCanal();
    }
    
    public void previousCanal(){
        tv.prevCanal();
    }
    
    public void escolherCanal(int canal){
        tv.trocarDireto(canal);
    }
    
    public void info(){
        tv.info();
    }
}
