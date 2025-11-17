package models;

public enum Tipo {
    BARCO(3),
    SUBMARINO(2),
    AVIAO(1);

    private int tamanho;

    Tipo(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

}
