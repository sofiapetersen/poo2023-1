/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopratico2;

import java.util.List;

/**
 *
 * @author sofiapetersen
 */

class PaginaNotas {
    private List<Anotacao> notas;
    private int notaSelecionadaIndex;

    public PaginaNotas(List<Anotacao> notas, int notaSelecionadaIndex) {
        this.notas = notas;
        this.notaSelecionadaIndex = notaSelecionadaIndex;
    }

    public List<Anotacao> getNotas() {
        return notas;
    }

    public int getNotaSelecionadaIndex() {
        return notaSelecionadaIndex;
    }

    public void setNotaSelecionadaIndex(int notaSelecionadaIndex) {
        this.notaSelecionadaIndex = notaSelecionadaIndex;
    }
}
