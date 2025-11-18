package models;

import java.util.ArrayList;
import java.util.Scanner;
//Cardinalidade de 1:N com Bonecos
//Cardinalidade de 1:N com Pontos
//Bidirecional com Partida
public abstract class Player{
    protected Tabuleiro defesa;
    protected Tabuleiro ataque;
    protected ArrayList<Bonecos> bonecos;
    protected ArrayList<Ponto> tirosRecebidos;
    protected Partida partida;
    protected String nome;

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
