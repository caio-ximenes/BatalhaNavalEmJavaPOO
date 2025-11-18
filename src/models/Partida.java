package models;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//Agregação: Usuario e adversario existem por si só e não dependem da Partida
//Cardinalidade de N:N com Player

public class Partida {
    //    A classe Partida é responsavel pelo inicio e setup da partida e pela lógica de jogo
    private Usuario player;
    private Adversario adversario;
    private ArrayList<Bonecos> bonecosPorPLayer1;
    private ArrayList<Bonecos> bonecosPorPLayer2;
    private static Scanner teclado = new Scanner(System.in);

    public Partida(String nome) {
        //Cria um ArrayList com os bonecos do Usuario

        this.bonecosPorPLayer1 = new ArrayList<>();
        this.bonecosPorPLayer1.add(new Barco());
        this.bonecosPorPLayer1.add(new Submarino());
        this.bonecosPorPLayer1.add(new Aviao());

        //Atribui eles ao Usuario
        this.player = new Usuario(bonecosPorPLayer1, nome, this);

        // Faz o mesmo para o adversario
        this.bonecosPorPLayer2 = new ArrayList<Bonecos>();
        this.bonecosPorPLayer2.add(new Barco());
        this.bonecosPorPLayer2.add(new Submarino());
        this.bonecosPorPLayer2.add(new Aviao());

        this.adversario = new Adversario(bonecosPorPLayer2, this);
    }

    public static void lore(String texto) throws InterruptedException {
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            System.out.print(letra);
            Thread.sleep(50);
        }
    }

    // Este é o método "Setup"
    public void iniciarPartida() {
        System.out.println("--- Setup do " + player.nome + " ---");
        this.posicionarFrota(player);

        System.out.println("--- Setup do " + adversario.nome + " ---");
        this.posicionarFrota(adversario);

        // O Setup chama o Game Loop
        this.comecarJogo();
    }



    //    Recolhe entradas do usuário de localização dos bonecos
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
            System.out.println("Digite a coluna (0-5)");
            int coordY = teclado.nextInt();
            System.out.println("Digite a linha (0-5)");
            int coordX = teclado.nextInt();
            return new Ponto(coordX, coordY);
        }
        else {
            System.out.println(mensagem);
            System.out.println("Digite a coluna (0-5)");
            int coordY = teclado.nextInt();
            System.out.println("Digite a linha (0-5)");
            int coordX = teclado.nextInt();
            return new Ponto(coordX, coordY);
        }
    }

    private void posicionarFrota(Player player) {
        System.out.println("\nPrepare sua frota, " + player.nome + "!");
        for (Bonecos boneco : player.bonecos) {
            boolean posicaoValida = false;
            while (!posicaoValida) {
                // Chama os métodos estáticos para pegar Ponto e Direcao
                Ponto ponto = Partida.recolherPontos("Em qual ponto o " + boneco.nome + " (Tamanho " + boneco.tamanho + ") vai começar?");
                Direcoes direcao = Partida.recolherDirecao(null);

                ArrayList<Ponto> pontos = new ArrayList<>();
                Ponto pontoAtual = ponto;
                for (int i = 0; i < boneco.tamanho; i++) {
                    if (pontoAtual == null) {
                        break;
                    }
                    pontos.add(pontoAtual);
                    pontoAtual = pontoAtual.pegarVizinho(direcao);
                }

                // Valida a posição no tabuleiro de DEFESA do player
                if (player.defesa.validarPosicao(pontos)) {
                    player.defesa.adicionarBarco(boneco, pontos);
                    posicaoValida = true;
                } else {
                    System.out.println("Posição inválida (fora do mapa ou sobreposta). Tente novamente.");
                }
            }
        }
    }

    // Este é o "Game Loop"
    public void comecarJogo() {
        Player atacante = this.player;
        Player defensor = this.adversario;
        teclado.nextLine(); // Consome o 'Enter' pendente do 'recolherDirecao'

        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Turno de " + atacante.nome);
            Ponto tiro = Partida.recolherPontos("Coordenadas do ataque:");

            Jogada jogada = new Jogada(tiro.getX(), tiro.getY(), atacante, defensor);
            jogada.atacar();

            if (defensor.defesa.tropasAbatidas()) {
                System.out.println("FIM DE JOGO! " + atacante.nome + " VENCEU!");
                break;
            }

            Player temp = atacante;
            atacante = defensor;
            defensor = temp;

            System.out.println("\nPressione Enter para passar o turno...");
            teclado.nextLine();
            // (Se o 'recolherPontos' deixar um 'Enter' pendente, você pode
            // precisar de outro teclado.nextLine() aqui, mas comece com um)
        }
    }

    // Metodo de ajuda para a 'Jogada'
    public Player getInimigo(Player atacante) {
        return (atacante == this.player) ? this.adversario : this.player;
    }
}