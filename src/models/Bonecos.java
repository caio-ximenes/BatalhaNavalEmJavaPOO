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

    //O tabuleiro chamará esse metodo e cada tipo de boneco receberá o tiro de uma forma
    public abstract boolean receberTiro(Ponto ponto);

    //Verificar se o boneco está destruído
    public abstract boolean abatido();



    }



