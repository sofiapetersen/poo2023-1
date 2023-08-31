/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopratico2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


/**
 *
 * @author sofiapetersen
 */
public class AnotacoesApp {
    private final List<Anotacao> lista;
    
    public AnotacoesApp() {
        lista = new ArrayList<>();
    }
    
    public void inserir(String titulo, String note, int dia, int mes, int ano) {
        Anotacao nota = new Anotacao(titulo, note, dia, mes, ano);
        lista.add(nota);
    }
    
    public Anotacao remover(int posicao) {
           if (posicao >= 0 && posicao < lista.size()) {
            return lista.remove(posicao);
        }
        return null;
    }
    
    public List<Anotacao> buscarSubstring(String substring) {
        List<Anotacao> notasEncontradas = new ArrayList<>();
        for (Anotacao notas : lista) {
            if (notas.contemSubstring(substring)) {
                notasEncontradas.add(notas);
            }
        }
        return notasEncontradas;
    }
    
    public List<Anotacao> buscarMes(int mes) {
        List<Anotacao> notasDoMes = new ArrayList<>();
        for (Anotacao notas : lista) {
            if (notas.buscaMes(mes)) {
                notasDoMes.add(notas);
            }
        }
        return notasDoMes;
    }
    
    
    public List<Anotacao> buscarDia(int dia) {
        List<Anotacao> notasDoDia = new ArrayList<>();
        for (Anotacao notas : lista) {
            if (notas.buscaDia(dia)) {
                notasDoDia.add(notas);
            }
        }
        return notasDoDia;
    }
    
    public void ordenar() {
        Collections.sort(lista, new Comparator<Anotacao>() {
        @Override
        public int compare(Anotacao nota1, Anotacao nota2) {
            return nota2.getData().compareTo(nota1.getData());
        }
    });
    }
    
    public void imprimir() {
        for (Anotacao nota : lista) {
            System.out.println(nota);
        }
    }
    
    public List<Anotacao> getLista() {
        return lista;
    }
    
public void ordenarPorTitulo() {
    Collections.sort(lista, new Comparator<Anotacao>() {
        @Override
        public int compare(Anotacao nota1, Anotacao nota2) {
            return nota1.getTitulo().compareToIgnoreCase(nota2.getTitulo());
        }
    });
}
   
    
    public void atualizarDescricao(Anotacao anotacao, String novaDescricao) {
        anotacao.setDescricao(novaDescricao);
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }
}
