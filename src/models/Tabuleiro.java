package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {

    //    Cardinalidade 1:N com Pontos
    private Map<Ponto, Bonecos> mapaMaritimo;
    private Map<Ponto, Bonecos> mapaAereo;
    private ArrayList<Ponto> jogadas;
    private ArrayList<Ponto> acertos;
    private ArrayList<Ponto> erros;
    private int tamanho;


    public Tabuleiro() {
        this.mapaMaritimo = new HashMap<>();
        this.mapaAereo = new HashMap<>();
        this.jogadas = new ArrayList<>();
        this.acertos = new ArrayList<>();
        this.erros = new ArrayList<>();
        this.tamanho = 6;
    }
    public void adicionarBarco(Bonecos boneco, ArrayList<Ponto> pontosDoBarco) {
        //Verifica se é avião para inserir no mapa aéreo para poder existir um avião sobrevoando um barco

        Map<Ponto, Bonecos> mapaAlvo;

        if (boneco instanceof Aviao) {
            mapaAlvo = this.mapaAereo;
        } else {
            mapaAlvo = this.mapaMaritimo;
        }
        for (int i = 0; i < pontosDoBarco.size(); i++) {

            Ponto ponto = pontosDoBarco.get(i);
            mapaAlvo.put(ponto, boneco);
        }

    }

    public boolean verificarAtaque(Ponto tiro){

        // 1. Verificamos o que tem nos mapas naquela coordenada
        // O tiro acerta primeiro quem está no ar, logo:
        Bonecos aviao = this.mapaAereo.get(tiro);


        //Verifica se o avião foi acertado para depois verificar o Mar
        if (aviao != null) {

            aviao.receberTiro(tiro);

            return true;
        }
        else {
            Bonecos embarcacao = this.mapaMaritimo.get(tiro);
            if (embarcacao != null) {

                embarcacao.receberTiro(tiro);

                return true;
            }
            else {
                return false;
            }
        }
    }


    public boolean validarPosicao(ArrayList<Ponto> pontos) {
        for (Ponto ponto : pontos) {
            if (ponto.getX() < 0 || ponto.getX() >= this.tamanho ||
                    ponto.getY() < 0 || ponto.getY() >= this.tamanho ||
                    this.mapaMaritimo.containsKey(ponto) || // Já ocupado (mar)
                    this.mapaAereo.containsKey(ponto)) {
                return false;
            }
        }
        return true;
    }

    public void registrarTiro(Ponto tiro, boolean acertou) {
        //No metodo atacar(coordenadaX, coordenadaY) em Player chamaremos esse metodo para deixar registrado o tiro
        //O parâmetro acertou é inicializado no metodo atacar
        if (acertou){
            this.acertos.add(tiro);
        }
        else {
            this.erros.add(tiro);
        }

        // Adiciona em 'jogadas' de qualquer forma, para
        // o 'jaAtirouAqui' funcionar.
        this.jogadas.add(tiro);
    }
    public boolean jaAtirouAqui(Ponto tiro) {
        return this.jogadas.contains(tiro);
    }

    public boolean tropasAbatidas(){
        if (this.mapaAereo.isEmpty() && this.mapaMaritimo.isEmpty()){
            System.out.println("Todas as tropas foram abatidas!");
            return true;
        }
        else {
            return false;
        }
    }
    public void removerDoMapa(Ponto tiro) {
        // A 'Jogada' chama este metodo DEPOIS que 'verificarAtaque'
        // retorna 'true' (acerto).
        this.mapaAereo.remove(tiro);
        this.mapaMaritimo.remove(tiro);
    }
    public void desenhar() {
        // Imprime o cabeçalho das colunas (coordenada Y)
        System.out.print("  "); // Espaço para a coordenada X
        for (int y = 0; y < this.tamanho; y++) {
            System.out.print(y + " ");
        }
        System.out.println(); // Nova linha

        // Itera sobre as linhas (coordenada X)
        for (int x = 0; x < this.tamanho; x++) {
            // Imprime o cabeçalho da linha (coordenada X)
            System.out.print(x + " ");

            // Itera sobre as colunas (coordenada Y)
            for (int y = 0; y < this.tamanho; y++) {
                // Cria um objeto Ponto para a coordenada atual
                // **ATENÇÃO:** O Ponto precisa ter implementado corretamente o equals() e hashCode()
                // para ser usado como chave em um HashMap.
                Ponto pontoAtual = new Ponto(x, y);

                // Verifica se há um Boneco (avião ou embarcação) nesta coordenada
                if (this.mapaAereo.containsKey(pontoAtual) || this.mapaMaritimo.containsKey(pontoAtual)) {
                    System.out.print("X "); // Posição ocupada por uma peça
                } else {
                    System.out.print("O "); // Posição de água (vazia)
                }
            }
            System.out.println(); // Nova linha após o fim de cada linha do tabuleiro
        }
    }

}