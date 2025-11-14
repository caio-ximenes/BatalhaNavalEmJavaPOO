package models;

import java.util.ArrayList;

public class Usuario extends Player{
    public Usuario(Tabuleiro defesa, Tabuleiro ataque, ArrayList<Bonecos> bonecos, ArrayList<Ponto> tirosRecebidos, String nome, Partida partida) {
        super(defesa, ataque, bonecos, tirosRecebidos, nome, partida);
    }
}
