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

    public Bonecos(Player player, int tamanho, Tabuleiro tabuleiro, ArrayList<Ponto> coordenadas, String nome) {
        this.player = player;
        this.tamanho = tamanho;
        this.tabuleiro = tabuleiro;
        this.coordenadas = coordenadas;
        this.nome = nome;
    }

/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**

/* <<<<<<<<<<  aad7c7a2-fba7-46ec-bce5-f87c5c7a5149  >>>>>>>>>>> */
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

    public void posicionarSe(Ponto ponto, Direcoes direcao) {
        boolean posicaoValida = this.tabuleiro.validarPosicao();

        if (posicaoValida){
            coordenadas.add(ponto);
            for(int i = 0; i < this.tamanho; i++){
                // 2. Usa apenas o enum corretamente:
                Ponto pontoVizinho = ponto.pegarVizinho(direcao);
                coordenadas.add(pontoVizinho);
            }
        }
    }

    }


