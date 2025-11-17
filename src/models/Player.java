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

    public Player(Tabuleiro defesa, Tabuleiro ataque, ArrayList<Bonecos> bonecos, String nome, Partida partida) {
        this.defesa = defesa;
        this.ataque = ataque;
        this.bonecos = bonecos;
        this.tirosRecebidos =  new ArrayList<Ponto>();
        this.nome = nome;
        this.partida = partida;
    }

    public boolean jaAtacou(Ponto tiro) {
        //Verifica se esse ponto já foi atacado
        if (this.ataque.jaAtirouAqui(tiro)) {
            return false;
        } else {
            return false;
        }
    }

    public boolean receberAtaque(Ponto tiro){
        this.tirosRecebidos.add(tiro);
        boolean acerto = this.defesa.verificarAtaque(tiro);
        if(acerto){
            this.bonecos.forEach(boneco -> boneco.receberTiro(tiro));
            return true;
        }
        else {
            return false;
        }
    }




}
