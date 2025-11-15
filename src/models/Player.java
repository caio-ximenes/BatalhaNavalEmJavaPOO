package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Tabuleiro defesa;
    Tabuleiro ataque;
    ArrayList<Bonecos> bonecos;
    ArrayList<Ponto> tirosRecebidos;
    Partida partida;
    String nome;

    public Player(Tabuleiro defesa, Tabuleiro ataque, ArrayList<Bonecos> bonecos, String nome, Partida partida) {
        this.defesa = defesa;
        this.ataque = ataque;
        this.bonecos = bonecos;
        this.tirosRecebidos =  new ArrayList<Ponto>();
        this.nome = nome;
        this.partida = partida;
    }

    public atacar(int coordenadaX, int coordenadaY){}


}
