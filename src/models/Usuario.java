package models;

import java.util.ArrayList;

public class Usuario extends Player{
    public Usuario(ArrayList<Bonecos> bonecos, String nome, Partida partida) {
        super(bonecos, nome, partida);
    }
    @Override
    public boolean jaAtacou(Ponto tiro) {
        //Verifica se esse ponto já foi atacado
        return this.ataque.jaAtirouAqui(tiro);

    }
    @Override
    public boolean receberAtaque(Ponto tiro){
        return this.defesa.verificarAtaque(tiro);

    }
}
