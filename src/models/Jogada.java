package models;

import java.util.ArrayList;

public class Jogada {
    Ponto ponto;
    Player player;
    ArrayList<Ponto> jogadas;

    public boolean atacar(int coordenadax, int coordenaday){
        Ponto ponto = new Ponto(coordenadax,coordenaday);
        player.receberAtaque(Ponto ponto);
        jogadas.add(ponto);
        if ()

    }
}
