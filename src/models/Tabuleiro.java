package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {

    private Map<Ponto, Bonecos> mapaMaritimo;
    private Map<Ponto, Bonecos> mapaAereo;
    private ArrayList<Ponto> jogadas;
    private ArrayList<Ponto> acertos;
    private ArrayList<Ponto> erros;

    public Tabuleiro() {
        this.mapaMaritimo = new HashMap<>();
        this.mapaAereo = new HashMap<>();
        this.jogadas = new ArrayList<>();
        this.acertos = new ArrayList<>();
        this.erros = new ArrayList<>();
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
        Bonecos embarcacao = this.mapaMaritimo.get(tiro);

        //Verifica se o avião foi acertado para depois verificar o Mar
        if (aviao!=null){
            System.out.println("FOGO! AVIÃO ABATIDO!!");
            aviao.receberTiro(tiro,this.mapaAereo);
            return true;
        }

        else {
            if (embarcacao != null) {
                System.out.println("FOGO!");
                boolean afundou = embarcacao.receberTiro(tiro, this.mapaMaritimo);

                if (afundou){
                    System.out.println("Você destruiu o: " + embarcacao.nome + "!");
                }
                return true;
            }
            else {
                System.out.println("ÁGUA!");



                return false;
            }
        }
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
    }
