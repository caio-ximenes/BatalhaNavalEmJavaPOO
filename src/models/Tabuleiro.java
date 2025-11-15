package models;

import java.util.ArrayList;

public class Tabuleiro {
    ArrayList<Ponto> pontosOcupados;
    ArrayList<Ponto> acertos;
    ArrayList<Ponto> erros;

    public Tabuleiro() {
        this.pontosOcupados = new ArrayList<>();
        this.acertos = new ArrayList<>();
        this.erros = new ArrayList<>();
    }
    public void adicionarBarco(ArrayList<Ponto> pontosOcupados){
        this.pontosOcupados.addAll(pontosOcupados);

    }
}
