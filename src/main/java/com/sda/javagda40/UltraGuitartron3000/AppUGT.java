package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.menu.ChordsHandler;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppUGT {
    static final String EXIT = "X";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ładowanie, proszę czekać...");
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        ChordsDao chordsDao = new ChordsDao();
        chordsDao.fillingChords();
        ChordsHandler chordsHandler = new ChordsHandler(SCANNER);
        chordsHandler.handle();
        PressEnterKeyToContinue.pressEnterKeyToContinue();

    }

}