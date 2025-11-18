package models;

import java.util.ArrayList;

public class Usuario extends Player{
    public Usuario(ArrayList<Bonecos> bonecos, String nome, Partida partida) {
        super(bonecos, nome, partida);
    }
    @Override
    public boolean receberAtaque(Ponto tiro){
        return this.defesa.verificarAtaque(tiro);

    }
}
