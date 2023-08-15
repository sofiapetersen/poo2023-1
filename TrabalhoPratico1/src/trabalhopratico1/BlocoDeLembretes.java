/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopratico1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 *
 * @author sofiapetersen
 */
public class BlocoDeLembretes {
    private final List<Lembretes> lista;
    
    public BlocoDeLembretes() {
        lista = new ArrayList<>();
    }
    
    public void inserir(String note, int dia, int mes, int ano) {
        Lembretes lembrete = new Lembretes(note, dia, mes, ano);
        lista.add(lembrete);
    }
    
    public Lembretes remover(int posicao) {
           if (posicao >= 0 && posicao < lista.size()) {
            return lista.remove(posicao);
        }
        return null;
    }
    
    public List<Lembretes> buscarSubstring(String substring) {
        List<Lembretes> lembretesEncontrados = new ArrayList<>();
        for (Lembretes lembrete : lista) {
            if (lembrete.contemSubstring(substring)) {
                lembretesEncontrados.add(lembrete);
            }
        }
        return lembretesEncontrados;
    }
    
    public List<Lembretes> buscarMes(int mes) {
        List<Lembretes> lembretesDoMes = new ArrayList<>();
        for (Lembretes lembrete : lista) {
            if (lembrete.buscaMes(mes)) {
                lembretesDoMes.add(lembrete);
            }
        }
        return lembretesDoMes;
    }
    
    
    public List<Lembretes> buscarDia(int dia) {
        List<Lembretes> lembretesDoDia = new ArrayList<>();
        for (Lembretes lembrete : lista) {
            if (lembrete.buscaDia(dia)) {
                lembretesDoDia.add(lembrete);
            }
        }
        return lembretesDoDia;
    }
    
    public void ordenar() {
        Collections.sort(lista, new Comparator<Lembretes>() {
        @Override
        public int compare(Lembretes lembrete1, Lembretes lembrete2) {
            return lembrete2.getData().compareTo(lembrete1.getData());
        }
    });
    }
    
    public void imprimir() {
        for (Lembretes lembrete : lista) {
            System.out.println(lembrete);
        }
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }
}
