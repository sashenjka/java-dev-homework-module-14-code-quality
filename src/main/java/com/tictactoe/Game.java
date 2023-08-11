package com.tictactoe;

import java.util.Scanner;

public class Game {
    private final Box box = new Box();
    private final static Scanner scan = new Scanner(System.in);

   private byte input() {
        while (true) {
            final byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box.isBoxEmpty((byte) (input - 1)))
                    System.out.println("That one is already in use. Enter another.");
                else {
                    return input;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }
    private boolean playHumanAndCheckIfWin() {
        byte input = input();
        box.fillBox((byte) (input - 1), 'X');

        return box.checkFinalCombination('X');
    }
    private byte doPC() {
        while (true) {
            final byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box.isBoxEmpty(((byte) (rand - 1)))) {
                return rand;
            }
        }
    }
    private boolean playPCAndCheckIfWin() {
        byte rnd = doPC();
        box.fillBox((byte) (rnd - 1), 'O');
        return box.checkFinalCombination('O');

    }
    private boolean checkDraw() {
        for (byte i = 0; i < 9; i++) {
            if (box.isBoxEmpty(i)) {
                return true;
            }
        }
        return false;
    }
    enum WINRESULT {
        WON, LOST, DRAW, GOING;
    }
    private WINRESULT playStrategy() {
        if (playHumanAndCheckIfWin()) {
            return WINRESULT.WON;
        } else if (checkDraw()) {
            return WINRESULT.DRAW;
        } else if (playPCAndCheckIfWin()) {
            return WINRESULT.LOST;
        }
        return WINRESULT.GOING;
    }
    public void play() {
        while (true) {
            box.printBoxInfo();

            final WINRESULT result = playStrategy();
            if (result != WINRESULT.GOING) {
                writeWinningMessage(result);
                return;
            }
        }
    }
    private void writeWinningMessage(final WINRESULT variant) {
        if (WINRESULT.WON.equals(variant)) {
            System.out.println(MESSAGE_ON_WON);
        } else if (WINRESULT.LOST.equals(variant)) {
            System.out.println(MESSAGE_ON_LOST);
        } else if (WINRESULT.DRAW.equals(variant)) {
            System.out.println(MESSAGE_ON_DRAW);
        }
    }
    private final static String MESSAGE_ON_WON = "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private final static String MESSAGE_ON_LOST = "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private final static String MESSAGE_ON_DRAW = "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
}

