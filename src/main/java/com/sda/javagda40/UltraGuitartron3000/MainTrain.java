package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.database.ScalesDao;
import com.sda.javagda40.UltraGuitartron3000.database.TraineeDao;
import com.sda.javagda40.UltraGuitartron3000.menu.Menu;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainTrain {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        System.out.println("Ładowanie...");

        ChordsDao chordsDao = new ChordsDao();
        ScalesDao scalesDao = new ScalesDao();
        TraineeDao traineeDao = new TraineeDao();

        chordsDao.fillingChords();
        scalesDao.fillingScales();
        traineeDao.fillingUsers();

        Scanner scanner = new Scanner(System.in);

        PressEnterKeyToContinue.pressEnterKeyToContinue();

        Menu menu = new Menu(scanner);

        menu.startMainMenu();


    }
}
