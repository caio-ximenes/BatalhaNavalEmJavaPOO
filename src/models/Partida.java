package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    //    A classe Partida é responsavel pelo inicio e setup da partida
    Player player;
    Adversario adversario;
    ArrayList<Bonecos> bonecosPorPLayer;

    public Partida(Player player, Adversario adversario) {
        this.player = player;
        this.adversario = adversario;
        this.bonecosPorPLayer = new ArrayList<Bonecos>();
    }

    public void iniciarPartida(String nome) {
        Barco b1 = new Barco();
        Barco b2 = new Barco();
        Submarino s2 = new Submarino();
        Aviao a1 = new Aviao();
        this.bonecosPorPLayer.add(b1);
        this.bonecosPorPLayer.add(b2);
        this.bonecosPorPLayer.add(s2);
        this.bonecosPorPLayer.add(a1);

        Tabuleiro defesaPlayer1 = new Tabuleiro();
        Tabuleiro ataquePlayer1 = new Tabuleiro();
        Player player1 = new Player(defesaPlayer1, ataquePlayer1, this.bonecosPorPLayer , nome, this);

        for (int i = 0; i < this.bonecosPorPLayer.size(); i++) {
            Bonecos boneco = this.bonecosPorPLayer.get(i);
            ArrayList<String> instrucoes = this.posicionarBonecos(boneco);

            ArrayList<Ponto> pontosReaisDoBarco = new ArrayList<>();

            int coordenadax = Integer.parseInt(instrucoes.get(0));
            int coordenaday = Integer.parseInt(instrucoes.get(1));
            String direcao = instrucoes.get(2);
            int tamanho = boneco.tamanho;
            for (int j = 0; j < tamanho; j++) {
                if (direcao.equals("Vertical")) {
                    pontosReaisDoBarco.add(new Ponto(coordenadax + j, coordenaday));
                } else { // "Horizontal"
                    pontosReaisDoBarco.add(new Ponto(coordenadax, coordenaday + j));
                }
            }

            defesaPlayer1.adicionarBarco(boneco,pontosReaisDoBarco);
        }

    }



    //    Recolhe entradas do usuário de localização dos bonecos
    public ArrayList<String> posicionarBonecos(Bonecos boneco) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolha a posicao do" + boneco.nome + ":");
        System.out.println("Linha: ");
        int linha = teclado.nextInt();
        System.out.println("Coluna: ");
        int coluna = teclado.nextInt();
        System.out.println("Direção:\nVertical(1)\nHorizontal(2) ");
        int direcao = teclado.nextInt();

        if (direcao == 1) {
            ArrayList<String> coordenadas = new ArrayList<String>();
            coordenadas.add(Integer.toString(linha));
            coordenadas.add(Integer.toString(coluna));
            coordenadas.add("Vertical");

            return coordenadas;
        } else if (direcao == 2) {
            ArrayList<String> coordenadas = new ArrayList<String>();
            coordenadas.add(Integer.toString(linha));
            coordenadas.add(Integer.toString(coluna));
            coordenadas.add("Horizontal");
            return coordenadas;
        }

        return null;
    }



}
