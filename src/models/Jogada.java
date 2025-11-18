package models;

import java.util.ArrayList;
//Composição com Partida: Jogadas não fazem sentido sem uma partida, e só são feitas durante uma partida
//Cardinalidade N:N com Player
public class Jogada {
    Ponto ponto;
    Player atacante;
    Player inimigo;
    Tabuleiro defesaInimigo;

    public Jogada(int coordenadax, int coordenaday, Player atacante, Player inimigo) {
        this.ponto = new Ponto(coordenadax, coordenaday);
        this.inimigo = inimigo;
        this.atacante = atacante;
        this.defesaInimigo = inimigo.defesa; // Pega o tabuleiro de defesa
    }

    public boolean atacar() {
        if(this.atacante.jaAtacou(ponto)){
            System.out.println("Você já atirou neste local!");
            return false;
        }

        boolean acertou = inimigo.receberAtaque(ponto);
        atacante.ataque.registrarTiro(ponto, acertou);

        if(acertou){
            System.out.println("Embarcações emm chamas! Você acertou!");

            this.defesaInimigo.removerDoMapa(ponto);
        }
        else {
                System.out.println("Míssel atingiu águas, comandante!");
        }

        return acertou;
    }



}


