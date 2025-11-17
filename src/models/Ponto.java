package models;

import java.util.ArrayList;
import java.util.Objects;

public class Ponto {
    private final int coordenadaX;
    private final int coordenadaY;

    public Ponto(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    public Ponto(ArrayList<String> coordenadas) {
        this.coordenadaX = Integer.parseInt(coordenadas.get(0));
        this.coordenadaY = Integer.parseInt(coordenadas.get(1));
    }



    public Ponto pegarVizinho(Direcoes direcao) {

        if (direcao == Direcoes.DIREITA) {
            return new Ponto(this.coordenadaX + 1, this.coordenadaY);

        } else if (direcao == Direcoes.ESQUERDA) {
            return new Ponto(this.coordenadaX - 1, this.coordenadaY);

        } else if (direcao == Direcoes.CIMA) {
            return new Ponto(this.coordenadaX, this.coordenadaY + 1);

        } else if (direcao == Direcoes.BAIXO) {
            return new Ponto(this.coordenadaX, this.coordenadaY - 1);
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return coordenadaX == ponto.coordenadaX && coordenadaY == ponto.coordenadaY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenadaX, coordenadaY);
    }
}
