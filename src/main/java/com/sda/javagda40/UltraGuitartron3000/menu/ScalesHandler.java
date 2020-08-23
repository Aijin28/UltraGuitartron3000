package com.sda.javagda40.UltraGuitartron3000.menu;

import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import com.sda.javagda40.UltraGuitartron3000.scales.ScalesController;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;
import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ScalesHandler {

    private final Scanner SCANNER;
    private ScalesController scalesController = new ScalesController();
    EntityDao<Scales> scalesEntityDao = new EntityDao<>();
    private int select;
    private Trainee user;

    public void handle() {
        boolean state = true;
        do{
            if (user.isAdminPermission()) {
                System.out.println("Co chcesz robić?\n" +
                        "1.Znajdź skalę\n" +
                        "2.Ćwicz skale\n" +
                        "3.Dodaj skalę\n" +
                        "4.Usuń skalę\n" +
                        "0.Powrót\n");
                try {
                    select = Integer.parseInt(SCANNER.nextLine());
                } catch (InputMismatchException|NumberFormatException ime) {
                    System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                }
                switch (select){
                    case 1:
                        findScale();
                        PressEnterKeyToContinue.pressEnterKeyToContinue();
                        break;
                    case 2:
                        scaleTraining(user);
                        PressEnterKeyToContinue.pressEnterKeyToContinue();
                        break;
                    case 3:
                        addScale(scalesEntityDao);
                        PressEnterKeyToContinue.pressEnterKeyToContinue();
                        break;
                    case 4:
                        deleteScale();
                        PressEnterKeyToContinue.pressEnterKeyToContinue();
                        break;
                    case 0:
                        state=false;
                        break;
                    default:
                        System.out.println("NIE MA TAKIEJ OPCJI!");
                        break;
                }
            } else {
                System.out.println("Co chcesz robić?\n" +
                        "1.Znajdź skalę\n" +
                        "2.Ćwicz skale\n" +
                        "0.Powrót\n");
                try {
                    select = Integer.parseInt(SCANNER.nextLine());
                } catch (InputMismatchException|NumberFormatException ime) {
                    System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                }
                switch (select){
                    case 1:
                        findScale();
                        PressEnterKeyToContinue.pressEnterKeyToContinue();
                        break;
                    case 2:
                        scaleTraining(user);
                        PressEnterKeyToContinue.pressEnterKeyToContinue();
                        break;
                    case 0:
                        state=false;
                        break;
                    default:
                        System.out.println("NIE MA TAKIEJ OPCJI!");
                        break;
                }
            }
        }while(state);
    }

    private void addScale(EntityDao<Scales> scalesEntityDao) {
        Scales newlyCreated = null;
        do {
            System.out.println("Podaj nazwę skali: ");
            String name = SCANNER.nextLine();
            try {
                System.out.println("Podaj pierwszą pozycję skali: ");
                int firstNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj drugą pozycję skali: ");
                int secondNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj trzecią pozycję skali: ");
                int thirdNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj czwartą pozycję skali: ");
                int fourthNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj piątą pozycję skali: ");
                int fifthNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj szóstą pozycję skali: ");
                int sixthNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj siódmą pozycję skali: ");
                int seventhNote = Integer.parseInt(SCANNER.nextLine());
                newlyCreated = new Scales(name, firstNote, secondNote, thirdNote, fourthNote, fifthNote, sixthNote, seventhNote);
                scalesEntityDao.saveOrUpdate(newlyCreated);
                System.out.println("dodano skalę: " + name);
            } catch (InputMismatchException ime) {
                System.out.println("Niewłaściwy zapis, wprowadź wartości jeszcze raz");
            }
        } while (newlyCreated == null || newlyCreated.getId() == null);
    }

    private int selectScale(EntityDao<Scales> scalesEntityDao) {
        int selectedScale;
        while (true) {
            System.out.println("Wybierz skalę z listy: ");
            System.out.println(scalesEntityDao.findAll(Scales.class));
            try {
                selectedScale = Integer.parseInt(SCANNER.nextLine());
                return selectedScale;
            } catch (InputMismatchException ime) {
                System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
            }
        }
    }

    private void findScale(){
        String scaleRootNote = NotesList.choosingRootNote(SCANNER);
        int selectedScale = selectScale(scalesEntityDao);
        List<String> result = scalesController.gettingScaleFromArray(scalesEntityDao.findById(Scales.class, selectedScale), scaleRootNote);
        for (String x : result) {
            System.out.print(x + "  ");
        }
    }

    private void deleteScale(){
        int selectedScale = selectScale(scalesEntityDao);
        scalesEntityDao.delete(scalesEntityDao.findById(Scales.class, selectedScale).get());
    }

    private void scaleTraining(Trainee user){
        String scaleRootNote = NotesList.rootNoteRandomizer();
        System.out.println("Twoja pryma to: " + scaleRootNote);
        int selectedScale = selectScale(scalesEntityDao);
        int checkedNotes = 0;
        System.out.println("Podaj pierwszy dźwięk skali: ");
        String firstNote = SCANNER.nextLine().toUpperCase();
        System.out.println("Podaj drugi dźwięk skali: ");
        String secondNote = SCANNER.nextLine().toUpperCase();
        System.out.println("Podaj trzeci dźwięk skali: ");
        String thirdNote = SCANNER.nextLine().toUpperCase();
        System.out.println("Podaj czwarty dźwięk skali: ");
        String fourthNote = SCANNER.nextLine().toUpperCase();
        System.out.println("Podaj piąty dźwięk skali: ");
        String fifthNote = SCANNER.nextLine().toUpperCase();
        System.out.println("Podaj szósty dźwięk skali: ");
        String sixthNote = SCANNER.nextLine().toUpperCase();
        System.out.println("Podaj siódmy dźwięk skali: ");
        String seventhNote = SCANNER.nextLine().toUpperCase();
        List<String> userGuessedNotes = Arrays.asList(firstNote, secondNote, thirdNote, fourthNote, fifthNote, sixthNote, seventhNote);
        List<String> guessedScaleNotes = scalesController.gettingScaleFromArray(scalesEntityDao.findById(Scales.class, selectedScale), scaleRootNote);
        for (int i = 0; i < userGuessedNotes.size(); i++) {
            String s = userGuessedNotes.get(i);
            if (s.equals(guessedScaleNotes.get(i))) {
                System.out.print(s + "  ");
                checkedNotes++;
            } else {
                System.out.print(s + "  ");
            }
        }
        System.out.println();
        for (String s : guessedScaleNotes){
            System.out.print(s + "  ");
        }
        System.out.println("Wynik: " + checkedNotes + "/7");
    }

    public ScalesHandler(Scanner scanner, Trainee user) {
        this.SCANNER = scanner;
        this.user = user;
    }

}
