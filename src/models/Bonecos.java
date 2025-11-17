package models;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Bonecos {
    private Player player;
    protected int tamanho;
    protected Tabuleiro tabuleiro;
    protected ArrayList<Ponto> coordenadas;
    protected ArrayList<Ponto> tirosRecebidos;
    protected String nome;
    protected Tipo tipo;


    public Bonecos(Player player, int tamanho, Tabuleiro tabuleiro, ArrayList<Ponto> coordenadas, String nome, Tipo tipo) {
        this.player = player;
        this.tamanho = tamanho;
        this.tabuleiro = tabuleiro;
        this.coordenadas = coordenadas;
        this.nome = nome;
        this.tipo = tipo;
    }

    public boolean receberTiro(Ponto ponto){
        this.tirosRecebidos.add(ponto);
        return this.abatido();
    }

    public boolean abatido(){
        if (this.tirosRecebidos.equals(this.coordenadas)){
            return true;
        }
        return false;
    }

    public boolean posicionarSe(Ponto ponto, Direcoes direcao) {
        ArrayList<Ponto> pontos = new ArrayList<>();
        for(int i = 0; i < this.tamanho; i++){
                // 2. Usa apenas o enum corretamente:
                Ponto pontoVizinho = ponto.pegarVizinho(direcao);
                pontos.add(pontoVizinho);
            }

        boolean posicaoValida = this.tabuleiro.validarPosicao(pontos);

        if (posicaoValida){
            coordenadas.addAll(pontos);
            this.tabuleiro.adicionarBarco(this, pontos);
            return true;
        }
        else {
            System.out.println("Posição inválida. Tente novamente.");
            return false;
        }
    }

    }


