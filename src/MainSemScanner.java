import models.Partida;


class MainSemScanner {
    public static void main(String[] args) throws InterruptedException {

        Partida.lore("Iniciando simulação automática Humano vs. IA...");
        Thread.sleep(2000);

        Partida partidaAtual = new Partida("Comandante (Humano)");

        partidaAtual.iniciarPartidaAutomatica();


    }
}