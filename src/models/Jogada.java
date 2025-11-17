package models;

import java.util.ArrayList;

public class Jogada {
    Ponto ponto;
    Player atacante;
    Player inimigo;

    public Jogada(int coordenadax, int coordenaday) {
        this.ponto = new Ponto(coordenadax, coordenaday);
    }

    public boolean atacar(int coordenadax, int coordenaday) {
        Ponto tiro = new Ponto(coordenadax, coordenaday);
        if(this.atacante.jaAtacou(tiro)){
            return false;
        }
        else {
            boolean ataque = inimigo.receberAtaque(tiro);
            if(ataque){
                System.out.println("Embarcações emm chamas! Você acertou!");
                return true;
            }
            else {
                System.out.println("Míssel atingiu águas comandante!");
                return true;
            }


        }



    }

}
