package com.tictactoe;

public class App {
    private static Game game = new Game();
    private static void printStartInfo() {
        System.out.println("Enter box number to select. Enjoy!\n");

        System.out.println("\n\n 1 | 2 | 3 ");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9 \n");
    }
    public static void main(String[] args) {
        printStartInfo();
        game.play();
    }
}



