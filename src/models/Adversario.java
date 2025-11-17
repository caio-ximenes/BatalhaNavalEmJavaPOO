package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Adversario extends Player {

    private static final List<String> NOMES = Arrays.asList(
            "Arthur", "Bernardo", "Carlos", "Daniel", "Eduardo",
            "Felipe", "Gabriel", "João", "Pedro",
            "Alice", "Beatriz", "Camila", "Diana", "Elisa",
            "Fernanda", "Giovana", "Helena", "Isabela", "Laura"
    );

    private static final Random RANDOM = new Random();

    public Adversario(ArrayList<Bonecos> bonecos, Partida partida) {
        String nomeAleatorio = gerarNome();
        super(bonecos, nomeAleatorio, partida);
    }

    private static String gerarNome() {
        int tamanhoLista = NOMES.size();
        int indiceAleatorio = RANDOM.nextInt(tamanhoLista);
        return NOMES.get(indiceAleatorio);
    }

}