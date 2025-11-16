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

    public void posicionarSe(Ponto ponto, Direcoes direcao){
        boolean posicaoValida = this.tabuleiro.validarPosicao();
        if (posicaoValida){
            coordenadas.add(ponto);
            for(int i = 0; i < this.tamanho; i++){
                if (direcao.equals("direita")) {
                    Ponto pontoVizinho = ponto.pegarVizinho(direcao);
                    coordenadas.add(pontoVizinho);
                }else if (direcao.equals("esquerda")) {
                    Ponto pontoVizinho = ponto.pegarVizinho(direcao);
                    coordenadas.add(pontoVizinho);
                }else if (direcao.equals("cima")) {
                    Ponto pontoVizinho = ponto.pegarVizinho(direcao);
                    coordenadas.add(pontoVizinho);
                }else if (direcao.equals("baixo")) {
                    Ponto pontoVizinho = ponto.pegarVizinho(direcao);
                    coordenadas.add(pontoVizinho);
                }

            }
        }

    }

}
