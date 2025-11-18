package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Adversario extends Player{

    private Random random;

    private static final List<String> NOMES = Arrays.asList(
            "Arthur", "Bernardo", "Carlos", "Daniel", "Eduardo",
            "Felipe", "Gabriel", "João", "Pedro",
            "Alice", "Beatriz", "Camila", "Diana", "Elisa",
            "Fernanda", "Giovana", "Helena", "Isabela", "Laura"
    );

    private static final Random RANDOM = new Random();

    public Adversario(ArrayList<Bonecos> bonecos, Partida partida) {
        String nomeAleatorio = gerarNome();
        this.random = new Random();

        super(bonecos, nomeAleatorio, partida);
    }

    private static String gerarNome() {
        int tamanhoLista = NOMES.size();
        int indiceAleatorio = RANDOM.nextInt(tamanhoLista);
        return NOMES.get(indiceAleatorio);
    }

    public Ponto ataqueAdversario() {
        int x = random.nextInt(6); // 0 a 5 (baseado no seu Tabuleiro.tamanho = 6)
        int y = random.nextInt(6); // 0 a 5

        Ponto tiro = new Ponto(x, y);

        // Tenta atirar até achar um ponto que não atirou ainda
        while (this.ataque.jaAtirouAqui(tiro)) {
            x = random.nextInt(6);
            y = random.nextInt(6);
            tiro = new Ponto(x, y);
        }
        System.out.println(this.nome + " ataca as coordenadas (" + x + ", " + y + ")");
        return tiro;
    }
}

