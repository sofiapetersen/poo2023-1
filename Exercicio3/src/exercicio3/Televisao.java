/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio3;

/**
 *
 * @author User
 */
public class Televisao {
        private int canal;
        private int volume;
        private final int VOLUME_MAX = 100;
        private final int CANAIS = 110;
        
        public void aumentarVol(){
            if(volume < VOLUME_MAX)
                volume++;
        }
        
        public void diminuirVol(){
            if(volume > 0)
                volume--;
        }
        
        public void proxCanal(){
            if (canal<CANAIS)
                canal++;
        }
        
        public void prevCanal(){
            if(canal >0)
                canal--;
        }
        
        public void trocarDireto(int novoCanal){
            if(novoCanal > 0 && novoCanal <= CANAIS)
                canal = novoCanal;
        }
        
        public void info(){
            System.out.println("");
            System.out.println("---");
            System.out.println("Canal: " + canal);
            System.out.println("Volume: " + volume);
            System.out.println("---");
            System.out.println("");
        }
}
