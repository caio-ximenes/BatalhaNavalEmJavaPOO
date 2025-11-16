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

    public void posicionarBonecos(Bonecos boneco) {
        bonecos.forEach(boneco -> boneco.posicionarSe());
    }


    public boolean atacar(int coordenadaX, int coordenadaY){
        Ponto tiro = new Ponto(coordenadaX,coordenadaY);
        Tabuleiro tabuleiroAdversario = this.partida.adversario.defesa;

        boolean acertou = tabuleiroAdversario.verificarAtaque(coordenadaX,coordenadaY);

        if(acertou){
            this.ataque.acertos.add(tiro);

        }
        else {
            this.ataque.erros.add(tiro);
        }
        return acertou;

    }




}
