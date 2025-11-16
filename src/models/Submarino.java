package models;

import java.util.Map;

public class Submarino extends  Bonecos{
    private  boolean submerso;

    public Submarino() {
        super(2, "Submarino");
        this.submerso = true;

    }

    @Override
    public boolean receberTiro(Ponto ponto, Map<Ponto, Bonecos> mapa) {
        if (this.submerso){
        System.out.println("Submarino descoberto!");
        this.submerso = false;

        return false;
        }
        else{
            if(!this.tirosRecebidos.contains(ponto)){
                this.tirosRecebidos.add(ponto);
            }
            //Retorna True se o Barco tiver sido abatido ou não
            return this.abatido();
        }
    }

    @Override
    public boolean abatido() {
        return this.tirosRecebidos.size() == this.tamanho;
    }
}
