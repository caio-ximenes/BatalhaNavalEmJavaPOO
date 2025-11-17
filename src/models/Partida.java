package models;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Partida {
    //    A classe Partida é responsavel pelo inicio e setup da partida e pela lógica de jogo
    private Usuario player;
    private Adversario adversario;
    private ArrayList<Bonecos> bonecosPorPLayer;
    private static Scanner teclado = new Scanner(System.in);
    public Partida(String nome) {
        Barco b1 = new Barco();
        Submarino s1 = new Submarino();
        Aviao a1 = new Aviao();
        this.bonecosPorPLayer.add(b1);
        this.bonecosPorPLayer.add(s1);
        this.bonecosPorPLayer.add(a1);
        this.player = new Usuario(bonecosPorPLayer, nome, this);
        this.adversario = new Adversario(bonecosPorPLayer, this);
        this.bonecosPorPLayer = new ArrayList<Bonecos>();
    }

    public static void lore(String texto) throws InterruptedException {
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            System.out.print("letra");
            Thread.sleep(200);
        }
    }

    public void iniciarPartida() {
        this.player.posicionarBonecos();
        this.adversario.posicionarBonecos();
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

    public static String reocolherEntradas(String mensagem){
        System.out.println(mensagem);
        return teclado.nextLine();
    }
    public static Direcoes recolherDirecao(String mensagem){
        if (mensagem == null){
            System.out.println("(1) Cima\n(2) Baixo\n(3) Direita\n(4) Esquerda");
            int direcao = teclado.nextInt();
            switch (direcao){
                case 1:
                    return Direcoes.CIMA;
                case 2:
                    return Direcoes.BAIXO;
                case 3:
                    return Direcoes.DIREITA;
                case 4:
                    return Direcoes.ESQUERDA;
                default:
                    return Direcoes.CIMA;
            }
        }
        else {
            System.out.println(mensagem);
            System.out.println("(1) Cima\n(2) Baixo\n(3) Direita\n(4) Esquerda");
            int direcao = teclado.nextInt();
            switch (direcao) {
                case 1:
                    return Direcoes.CIMA;
                case 2:
                    return Direcoes.BAIXO;
                case 3:
                    return Direcoes.DIREITA;
                case 4:
                    return Direcoes.ESQUERDA;
                default:
                    return Direcoes.CIMA;
            }
        }

    }
    public static Ponto recolherPontos(String mensagem){
        if (mensagem == null){
            System.out.println("Digite a coluna");
            int coordY = teclado.nextInt();
            System.out.println("Digite a linha");
            int coordX = teclado.nextInt();
            return new Ponto(coordX, coordY);
        }
        else {
            System.out.println(mensagem);
            System.out.println("Digite a coluna");
            int coordY = teclado.nextInt();
            System.out.println("Digite a linha");
            int coordX = teclado.nextInt();
            return new Ponto(coordX, coordY);
        }
    }

}
