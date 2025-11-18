import models.Partida;

import java.util.Scanner;


class MainSemScanner {
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
        String nome = "Caio";
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
        String resposta = "s";
        while(true) {
            if (resposta.equalsIgnoreCase("s")) {
                String resultado = partidaAtual.iniciarPartidaAutomatica();
                if (resultado == null) {
                    Thread.sleep(2000);
                } else if (resultado.equals(nome)) {
                    Partida.lore("Comandante foi uma honra! Vencemos!");
                    Thread.sleep(2000);
                    System.out.printf("Ao Comandante %s!", nome);
                    Partida.lore("Vivaaa!");
                    System.exit(0);
                } else {
                    Partida.lore("Comandante nossas tropas foram afundadas!");
                    Thread.sleep(2000);
                    Partida.lore("Foi uma honra comandante!");
                    Partida.lore("*Míssel acerta o navio e explode você e o capitão Shelton");
                    System.exit(0);
                }
            } else if (resposta.toLowerCase().equals("n")) {
                System.exit(0);
            } else {
                Partida.lore("Digite uma opção válida");
            }
        }
        }

    }
