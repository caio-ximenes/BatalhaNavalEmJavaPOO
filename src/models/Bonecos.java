package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public abstract class Bonecos {
    protected int tamanho;
    protected ArrayList<Ponto> tirosRecebidos;
    protected String nome;

    public Bonecos(int tamanho, String nome) {
        this.tamanho = tamanho;
        this.nome = nome;
        this.tirosRecebidos = new ArrayList<>();
    }

    //O tabuleiro chamará esse metodo e cada tipo de boneco receberá o tiro de uma forma
    public abstract boolean receberTiro(Ponto ponto, Map<Ponto, Bonecos> mapa);

    //Verificar se o boneco está destruído
    public abstract boolean abatido();



    }


