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

    public boolean atacar(int coordenadaX,int coordenadaY){
        Ponto tiro = new Ponto(coordenadaX,coordenadaY);

        //Verifica se esse ponto já foi atacado
        if (this.ataque.jaAtirouAqui(tiro)){
            System.out.println("Você já atirou neste ponto.");
            return false;
        }
        //Ataca o tabuleiro do adversário
        Tabuleiro tabuleiroAdversario = this.partida.adversario.defesa;
        boolean acertou = tabuleiroAdversario.verificarAtaque(tiro);

        //Registra o ataque no seu tabuleiro de ataque
        this.ataque.registrarTiro(tiro, acertou);

        //Retorna True se o tiro acertou e false se errou
        return acertou;

    }

    public boolean receberAtaque(Ponto tiro){
        //Quando um usuário utilizar o metodo atacar() o adversário chamará o metodo receberAtaque()
        // e retornará true se acertar e false se errar
        boolean acertou = this.defesa.verificarAtaque(tiro);

        return acertou;
    }




}
