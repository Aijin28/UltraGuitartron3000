package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.database.ScalesDao;
import com.sda.javagda40.UltraGuitartron3000.database.TraineeDao;
import com.sda.javagda40.UltraGuitartron3000.menu.ChordsHandler;
import com.sda.javagda40.UltraGuitartron3000.menu.Menu;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppUGT {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ładowanie, proszę czekać...");
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        ChordsDao chordsDao = new ChordsDao();
        ScalesDao scalesDao = new ScalesDao();
        TraineeDao traineeDao = new TraineeDao();
        Menu menu = new Menu(SCANNER);

        chordsDao.fillingChords();
        scalesDao.fillingScales();
        traineeDao.fillingUsers();

        System.err.println("\n(☞ﾟヮﾟ)☞ Witaj w Ultra Guitartron 3000!! ☜(ﾟヮﾟ☜)");

        PressEnterKeyToContinue.pressEnterKeyToContinue();

        menu.startMainMenu();
    }
}