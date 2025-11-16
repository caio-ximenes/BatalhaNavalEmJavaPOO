package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {

    private Map<Ponto, Bonecos> mapaDosBarcos;
    private ArrayList<Ponto> jogadas;
    private ArrayList<Ponto> acertos;
    private ArrayList<Ponto> erros;

    public Tabuleiro() {
        this.mapaDosBarcos = new HashMap<>();
        this.jogadas = new ArrayList<>();
        this.acertos = new ArrayList<>();
        this.erros = new ArrayList<>();
    }
    public void adicionarBarco(Bonecos boneco, ArrayList<Ponto> pontosDoBarco){
        for (int i = 0; i < pontosDoBarco.size(); i++) {

            Ponto ponto = pontosDoBarco.get(i);

            this.mapaDosBarcos.put(ponto, boneco);
        }

    }
    public boolean verificarAtaque(Ponto tiro){

        // 1. Verificamos o que tem no mapa naquela coordenada
        Bonecos bonecoAtingido = this.mapaDosBarcos.get(tiro);

        if (bonecoAtingido == null) {
            System.out.println("ÁGUA!");
            return false;
        }
        else {
            System.out.println("FOGO!");
            boolean afundou = bonecoAtingido.receberTiro(tiro);
            this.mapaDosBarcos.remove(tiro); // Remove para não acertar de novo

            if (afundou) {
                System.out.println("Você destruiu o: " + bonecoAtingido.nome + "!");
            }
            return true;
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
    }
