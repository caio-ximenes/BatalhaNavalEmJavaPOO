package models;

import java.util.Objects;

public class Ponto {
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
