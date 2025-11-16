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

    public Bonecos(int tamanho, String nome) {
        this.tamanho = tamanho;
        this.nome = nome;
        this.coordenadas = new ArrayList<>();
        this.tirosRecebidos = new ArrayList<>();
    }


    public abstract boolean receberTiro(Ponto ponto);

    public abstract boolean abatido();

