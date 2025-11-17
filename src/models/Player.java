package models;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {
    Tabuleiro defesa;
    Tabuleiro ataque;
    ArrayList<Bonecos> bonecos;
    ArrayList<Ponto> tirosRecebidos;
    Partida partida;
    String nome;

    public Player(ArrayList<Bonecos> bonecos, String nome, Partida partida) {
        this.defesa = new Tabuleiro();
        this.ataque = new Tabuleiro();
        this.bonecos = bonecos;
        this.nome = nome;
        this.partida = partida;
    }

    public boolean jaAtacou(Ponto tiro) {
        //Verifica se esse ponto já foi atacado
        return this.ataque.jaAtirouAqui(tiro);

    }

    public boolean receberAtaque(Ponto tiro){
            return this.defesa.verificarAtaque(tiro);

    }




}
