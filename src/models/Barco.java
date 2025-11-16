package models;

import java.util.Map;

public class Barco extends Bonecos{
    public Barco() {
        super(3,"Barco") ;

    }

    @Override
    public boolean receberTiro(Ponto ponto, Map<Ponto, Bonecos> mapa) {
        //Se esse barco não tiver recebido tiro, adiciona o ponto do tiro tomado ao Arraylist de tiros recebidos
        if(!this.tirosRecebidos.contains(ponto)){
            this.tirosRecebidos.add(ponto);
        }

        mapa.remove(ponto);

        //Retorna True se o Barco tiver sido abatido ou não
        return this.abatido();

        }


    @Override
    public boolean abatido() {
        //Verifica se o Barco já tomou a quantidade de tiros equivalente ao tamanho dele
        return this.tirosRecebidos.size() == this.tamanho;
    }


}
