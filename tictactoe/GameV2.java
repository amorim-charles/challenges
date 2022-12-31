package br.com.charles.challenge.tictactoe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameV2 {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    final String BG_RED = "\u001b[41m";
    final String BG_GREEN = "\u001b[42m";
    final String BG_WHITE = "\033[0;107m";
    final String BG_COLOR = new String();
    final String BG_RESET = "\u001b[0m";
    final String TX_WHITE_BOLD = "\033[1;97m";
    final String TX_BLACK_BOLD = "\033[1;90m";
    final String TX_GREEN_BOLD = "\033[1;92m";
    final String TX_CYAN_BOLD = "\033[1;96m";
    final String TX_PURPLE_BOLD = "\033[1;95m";
    final String TX_RED_BOLD = "\033[0;91m";
    final String FEATURE = "―";
    String savePlays[] = {"", "", "", "", "", "", "", "", ""};
    String winner[] = {"", "", "", "", "", "", "", "", ""};
    String board[][] = new String[3][3];
    String dialog = "escolha uma posição: ";
    String tab;
    String bar;
    String player;
    byte savePositions[] = new byte[9];
    byte count = 1;
    byte round = 0;
    byte finish = 0;
    int selectPlayer = random.nextInt(1, 2);
    int position;
    boolean test = false;

    public void play() throws Exception {

        do {
            header();

            for (byte i = 0; i < board.length; i++) {
                for (byte j = 0; j < board.length; j++) {

                    checkWinner(round);
                    tab = tab(j);
                    bar = bar(j);

                    byte play = (byte) (count -1);
                    if (round > 4 && savePlays[play].equals(winner[play]) && savePlays[play] != "") {
                        System.out.print(tab + BG_RED + TX_WHITE_BOLD + "   " + winner[play] + "   " + BG_RESET + bar);
                        finish++;
                        if (finish == 3) {
                            round = 10;
                            player = winner[0];
                        }
                    } else if (savePlays[play] == "\uD83C\uDF15" || savePlays[play] == "⨉") {
                        System.out.print(tab + BG_GREEN + TX_WHITE_BOLD + "   " + savePlays[play] + "   " + BG_RESET + bar);
                    } else {
                        System.out.print(tab + BG_GREEN + TX_WHITE_BOLD + "   " + count + "   " + BG_RESET + bar);
                    }
                    count++;
                }

                if (count < 9) {
                    System.out.println();
                    System.out.println("\t\t\t\t" + FEATURE.repeat(19));
                }
            }

            System.out.println('\n');
            while (!test) {
                try {
                    if (finish == 3) {
                        if (player.equals("⨉")) {
                            System.out.println(TX_CYAN_BOLD + "\t\t\t\t\tPlayer1, VENCEU!!! ");
                        } else if (player.equals("\uD83C\uDF15")) {
                            System.out.println(TX_CYAN_BOLD + "\t\t\t\t\tPlayer2, VENCEU!!! ");
                        }
                        break;
                    }

                    if (selectPlayer == 1) {
                        System.out.print(TX_CYAN_BOLD + "\t\t\t\tPlayer1, " + dialog);
                        player = "⨉";
                    }

                    if (selectPlayer == 2) {
                        System.out.print(TX_CYAN_BOLD + "\t\t\t\tPlayer2, " + dialog);
                        player = "\uD83C\uDF15";
                    }

                    position = scanner.nextInt();
                    boolean testPosition = testPosition(position);

                    if (testPosition == true) {
                        savePositions[round] = (byte) position;
                        int savePlay = position - 1;
                        savePlays[savePlay] = player;
                        test = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println(TX_RED_BOLD + "\t\t\t\t    Digite apenas números.");
                    scanner.nextLine();

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(TX_RED_BOLD + "\t\t\t\t Digite números do tabuleiro.");
                    scanner.nextLine();
                }
            }

            selectPlayer = switchPlayers(selectPlayer);
            count = 1;
            round++;
            test = false;
            System.out.println("\n");

        } while (round < 10);
    }

    private String tab(byte j) {
        if (j == 0 || j == 3 || j == 6) {
            return tab = "\t\t\t\t";
        } else {
            return tab = "  ";
        }
    }

    private String bar(byte j) {
        if (j == 2 || j == 5 || j == 8) {
            return bar = "";
        } else {
            return bar = "  |";
        }
    }

    private int switchPlayers(int player) {
        if (player == 1)
            return player = 2;
        else
            return player = 1;
    }

    private void header() {
        System.out.println();
        System.out.println(TX_PURPLE_BOLD + "\t\t\t\t Jogo da Velha - Tic-Tac-Toe");
        System.out.println(FEATURE.repeat(37));
        System.out.println();
        System.out.print(TX_CYAN_BOLD + "\t\t\t\tPlayer1: " + TX_GREEN_BOLD + "⨉"); //〇 ⨉
        System.out.println(TX_CYAN_BOLD + "\t\t\tPlayer2: " + TX_GREEN_BOLD + "\uD83C\uDF15");
        System.out.println();
    }

    private boolean testPosition(int position) {
        for (byte save : savePositions) {
            if (position == save) {
                System.out.println(TX_RED_BOLD + "\t\t\t\t\t  Oops..Essa já foi.");
                return false;
            }
        }
        System.out.println(TX_PURPLE_BOLD + FEATURE.repeat(37));
        return true;
    }

    private String checkWinner(int round) {
        if (round > 4) {
            if (savePlays[0].equals(savePlays[1]) && savePlays[1].equals(savePlays[2]) && savePlays[0] != "") {
                winner[0] = savePlays[0];
                winner[1] = savePlays[1];
                winner[2] = savePlays[2];
                return winner[0];
            }
            if (savePlays[3].equals(savePlays[4]) && savePlays[4].equals(savePlays[5]) && savePlays[3] != "") {
                winner[3] = savePlays[3];
                winner[4] = savePlays[4];
                winner[5] = savePlays[5];
                return winner[3];
            }
            if (savePlays[6].equals(savePlays[7]) && savePlays[7].equals(savePlays[8])&& savePlays[6] != "") {
                winner[6] = savePlays[6];
                winner[7] = savePlays[7];
                winner[8] = savePlays[8];
                return winner[6];
            }
            if (savePlays[0].equals(savePlays[3]) && savePlays[3].equals(savePlays[6])&& savePlays[0] != "") {
                winner[0] = savePlays[0];
                winner[3] = savePlays[3];
                winner[6] = savePlays[6];
                return winner[0];
            }
            if (savePlays[1].equals(savePlays[4]) && savePlays[4].equals(savePlays[7])&& savePlays[1] != "") {
                winner[1] = savePlays[1];
                winner[4] = savePlays[4];
                winner[7] = savePlays[7];
                return winner[1];
            }
            if (savePlays[2].equals(savePlays[5]) && savePlays[5].equals(savePlays[8])&& savePlays[2] != "") {
                winner[2] = savePlays[2];
                winner[5] = savePlays[5];
                winner[8] = savePlays[8];
                return winner[2];
            }
            if (savePlays[0].equals(savePlays[4]) && savePlays[4].equals(savePlays[8])&& savePlays[0] != "") {
                winner[0] = savePlays[0];
                winner[4] = savePlays[4];
                winner[8] = savePlays[8];
                return winner[0];
            }
            if (savePlays[2].equals(savePlays[4]) && savePlays[4].equals(savePlays[6])&& savePlays[2] != "") {
                winner[2] = savePlays[2];
                winner[4] = savePlays[4];
                winner[6] = savePlays[6];
                return winner[2];
            }
        }
        return null;
    }
}
