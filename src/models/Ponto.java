package models;

import java.util.Objects;

public class Ponto {
    private int coordenadaX;
    private int coordenadaY;

    public Ponto(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }


    public Ponto pegarVizinho(Direcoes direcao) {
        if (direcao == Direcoes.DIREITA) {
            Ponto pontoVizinho = new Ponto(this.coordenadaX + 1, this.coordenadaY);
            return pontoVizinho;
        } else if (direcao == Direcoes.ESQUERDA) { // Use o nome exato do ENUM
            Ponto pontoVizinho = new Ponto(this.coordenadaX - 1, this.coordenadaY);
            return pontoVizinho;
        } else if (direcao == Direcoes.CIMA) {    // Use o nome exato do ENUM
            Ponto pontoVizinho = new Ponto(this.coordenadaX, this.coordenadaY + 1);
            return pontoVizinho;
        } else if (direcao == Direcoes.BAIXO) {   // Use o nome exato do ENUM
            Ponto pontoVizinho = new Ponto(this.coordenadaX, this.coordenadaY - 1);
            return pontoVizinho;
        }
    private final int coordenadax;
    private final int coordenaday;

    public Ponto(int coordenadax, int coordenaday) {
        this.coordenadax = coordenadax;
        this.coordenaday = coordenaday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return coordenadax == ponto.coordenadax && coordenaday == ponto.coordenaday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenadax, coordenaday);
    }
}
