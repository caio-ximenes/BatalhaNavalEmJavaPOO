package models;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Bonecos {
    Tabuleiro tabuleiro;
    ArrayList<Objects> coordenadas;
    int tamanho;
    Player player;
    ArrayList<Object> tirosRecebidos;
    String nome;

    public abstract boolean receberTiro(Ponto ponto);

    public abstract boolean abatido();

