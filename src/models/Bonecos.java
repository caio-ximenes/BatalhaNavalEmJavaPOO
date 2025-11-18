package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;


public abstract class Bonecos {
    protected int tamanho;
    protected ArrayList<Ponto> tirosRecebidos;
    protected String nome;
    protected Tipo tipo;


    public Bonecos(Tipo tipo) {
        this.tipo = tipo;
        this.tamanho = tipo.getTamanho();
        this.nome = tipo.toString();
        this.tirosRecebidos = new ArrayList<>();
    }
    //Verificar se o boneco está destruído
    public abstract boolean abatido();


    //O tabuleiro chamará esse metodo e cada tipo de boneco receberá o tiro de uma forma
    public boolean receberTiro(Ponto ponto) {
        //Se esse barco não tiver recebido tiro, adiciona o ponto do tiro tomado ao Arraylist de tiros recebidos
        if(!this.tirosRecebidos.contains(ponto)){
            this.tirosRecebidos.add(ponto);
        }

        //Retorna True se o Avião tiver sido abatido ou não
        return this.abatido();

    }




    }



