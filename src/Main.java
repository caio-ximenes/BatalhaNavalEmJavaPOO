//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import models.Jogada;
import models.Partida;
import models.Tabuleiro;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

 class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("██████╗  █████╗ ████████╗ █████╗ ██╗      ███╗   ██╗ █████╗ ██╗   ██╗ █████╗ ██╗     \n" +
                "██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██║      ████╗  ██║██╔══██╗██║   ██║██╔══██╗██║     \n" +
                "██████╔╝███████║   ██║   ███████║██║      ██╔██╗ ██║███████║██║   ██║███████║██║     \n" +
                "██╔══██╗██╔══██║   ██║   ██╔══██║██║      ██║╚██╗██║██╔══██║██║   ██║██╔══██║██║     \n" +
                "██████╔╝██║  ██║   ██║   ██║  ██║███████╗ ██║ ╚████║██║  ██║╚██████╔╝██║  ██║███████╗\n" +
                "╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝╚══════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝\n");
        System.out.println("⠀⠀⠀⠀⣠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠰⠶⢿⡶⠦⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⣈⣙⣻⣿⣏⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣿⡏⡟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢰⣿⣷⣷⣶⣶⣆⡤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⢀⣀⣿⣿⣿⣿⣿⣿⡇⢀⠀⢀⡀⠀⣀⣀⣠⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⣸⣿⣿⣿⣿⣿⣿⡟⣿⣍⢿⣿⣿⣷⣾⣿⣿⣻⣿⡟⠿⣶⣤⣤⣤⣄⣀⡀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠉⠻⠿⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣿⣶⣶⣾⣧⣤⣴⣆⣀⢀⣤⡄⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠻⢿⣿⣿⣿⣿⣶⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣯⣽⣯⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣧⣶⣤⣤⣤⣾⣿⡇⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠈⠙⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣉⠛⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣭⣤⣤⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣽⣿⣿⣿⣿⣿⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠸\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠛⠷⠾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠉⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠛⠻⠿⢿⣿⣿⣿⣯⣉⠉⠙⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠛⠿⠿⣶⣶⣶⣦⣍⣉⣹⣉⠙⠻⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠛⠛⠻⠿⢷⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        Partida.lore("Quem é você?");
        Thread.sleep(3000);
        Partida.lore("*Olha para baixo");
        Thread.sleep(1000);
        Partida.lore("Digite seu nome:");
        System.out.print("-> ");
        String nome = teclado.next();
        Thread.sleep(1000);
        System.out.printf("Me desculpe Comandante %s",nome);
        Thread.sleep(2000);
        Partida.lore("Nossa nação está sendo atacada e só você pode nos ajudar...");
        for(int i = 0; i < 50; i++){
            System.out.print("=");
            Thread.sleep(200);
        }
        Partida partidaAtual = new Partida(nome);
        Partida.lore("\nPronto?(s/n)");
        System.out.print("-> ");
        String resposta = teclado.next();
        while(true) {
            if (resposta.equalsIgnoreCase("s")) {
                partidaAtual.iniciarPartida();
                break;
            } else if (resposta.toLowerCase().equals("n")) {
                System.exit(0);
            } else {
                Partida.lore("Digite uma opção válida");
            }
        }

    while(true){
        Partida.lore("Comandante, qual linha devemos atacar? (Digite número de 1 a 5)");
        int linha = teclado.nextInt();
        Partida.lore("Comandante, qual coluna devemos atacar? (Digite número de 1 a 5)");
        int coluna = teclado.nextInt();
        partidaAtual.atacar(coluna,linha);
        Thread.sleep(2000);
        partidaAtual.defender();
        String ganhador = partidaAtual.vencedor();
        if(ganhador == null){
            Thread.sleep(2000);
        }
        else {
            if (ganhador.equals("Comandante")) {
                Partida.lore("Comandante foi uma honra! Vencemos!");
                Thread.sleep(2000);
                System.out.printf("Ao Comandante %s!",nome);
                Partida.lore("Vivaaa!");
                System.exit(0);
            }
            else{
                Partida.lore("Comandante nossas tropas foram afundadas!");
                Thread.sleep(2000);
                Partida.lore("Foi uma honra comandante!");
                Partida.lore("*Míssel acerta o navio e explode você e o capitão Shelton");
                System.exit(0);
            }

        }


    }

    }
}

