package models;

import java.util.ArrayList;

public class Tabuleiro {
    ArrayList<Ponto> pontosOcupados;
    ArrayList<Ponto> acertos;
    ArrayList<Ponto> erros;
    ArrayList<Ponto> jogadas;

    public Tabuleiro() {
        this.pontosOcupados = new ArrayList<>();
        this.acertos = new ArrayList<>();
        this.erros = new ArrayList<>();
        this.jogadas = new ArrayList<>();
    }
    public void adicionarBarco(ArrayList<Ponto> pontosOcupados){
        this.pontosOcupados.addAll(pontosOcupados);

    }
    public boolean verificarAtaque(int coordenadaX, int coordenadaY){
        Ponto tiro = new Ponto(coordenadaX,coordenadaY);
        boolean acertou = this.pontosOcupados.contains(tiro);
        if (acertou){
            System.out.println("FOGO! ACERTOU!");
            acertos.add(tiro);
        }
        else {
            System.out.println("ÁGUA! ERROU!");
            erros.add(tiro);
        }
        jogadas.add(tiro);
        return acertou;
    }
}
