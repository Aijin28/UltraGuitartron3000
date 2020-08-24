package com.sda.javagda40.UltraGuitartron3000.menu;

import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import com.sda.javagda40.UltraGuitartron3000.scales.ScalesController;
import com.sda.javagda40.UltraGuitartron3000.utils.Notes;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;
import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

import java.util.*;

public class ScalesHandler {

    private final Scanner SCANNER;
    EntityDao<Scales> scalesEntityDao = new EntityDao<>();
    private ScalesController scalesController = new ScalesController();
    private int select;
    private Trainee user;

    public ScalesHandler(Scanner scanner, Trainee user) {
        this.SCANNER = scanner;
        this.user = user;
    }

    public void handle() {
        boolean state = true;
        do {
            if (user.isAdminPermission()) {
                System.out.println(
                                "----------------------------\n" +
                                "|        +S K A L E+       |\n" +
                                "|      1.Znajdź skalę      |\n" +
                                "|      2.Ćwicz skalę       |\n" +
                                "|      3.Dodaj skalę       |\n" +
                                "|      4.Usuń skalę        |\n" +
                                "|      0.Powrót            |\n" +
                                "|                          |\n" +
                                "----------------------------\n");
                try {
                    select = Integer.parseInt(SCANNER.nextLine());
                } catch (InputMismatchException | NumberFormatException ime) {
                    System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                }
                switch (select) {
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
                        state = false;
                        break;
                    default:
                        System.out.println("NIE MA TAKIEJ OPCJI!");
                        break;
                }
            } else {
                System.out.println(
                                "----------------------------\n" +
                                "|        +S K A L E+       |\n" +
                                "|      1.Znajdź skalę      |\n" +
                                "|      2.Ćwicz skalę       |\n" +
                                "|      0.Powrót            |\n" +
                                "|                          |\n" +
                                "----------------------------\n");
                try {
                    select = Integer.parseInt(SCANNER.nextLine());
                } catch (InputMismatchException | NumberFormatException ime) {
                    System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                }
                switch (select) {
                    case 1:
                        findScale();
                        PressEnterKeyToContinue.pressEnterKeyToContinue();
                        break;
                    case 2:
                        scaleTraining(user);
                        PressEnterKeyToContinue.pressEnterKeyToContinue();
                        break;
                    case 0:
                        state = false;
                        break;
                    default:
                        System.out.println("NIE MA TAKIEJ OPCJI!");
                        break;
                }
            }
        } while (state);
    }

    private void addScale(EntityDao<Scales> scalesEntityDao) {
        Scales newlyCreated = null;
        do {
            System.out.println("Podaj nazwę skali: ");
            String name = SCANNER.nextLine();
            try {
                System.out.println("Podaj pierwszą pozycję skali: ");
                int firstNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj drugą pozycję skali: ");
                int secondNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj trzecią pozycję skali: ");
                int thirdNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj czwartą pozycję skali: ");
                int fourthNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj piątą pozycję skali: ");
                int fifthNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj szóstą pozycję skali: ");
                int sixthNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj siódmą pozycję skali: ");
                int seventhNote = Notes.noteInsert(SCANNER);
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
            List<Scales> scalesList = scalesEntityDao.findAll(Scales.class);
            for (Scales scale : scalesList) {
                System.out.println(scale.getId() + ". " + scale.getScaleName());
            }
            try {
                selectedScale = Integer.parseInt(SCANNER.nextLine());
                return selectedScale;
            } catch (InputMismatchException ime) {
                System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
            }
        }
    }

    private void findScale() {
        String scaleRootNote = Notes.choosingRootNote(SCANNER);
        int selectedScale = selectScale(scalesEntityDao);
        Optional<Scales> scaleById = scalesEntityDao.findById(Scales.class, selectedScale);
        List<String> result = scalesController.gettingScaleFromArray(scaleById, scaleRootNote);
        for (String x : result) {
            System.out.print(x + "  ");
        }
        System.out.println();
    }

    private void deleteScale() {
        int selectedScale = selectScale(scalesEntityDao);
        scalesEntityDao.delete(scalesEntityDao.findById(Scales.class, selectedScale).get());
    }

    private void scaleTraining(Trainee user) {
        String scaleRootNote = Notes.rootNoteRandomizer();
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
        for (String s : guessedScaleNotes) {
            System.out.print(s + "  ");
        }
        System.out.println("Wynik: " + checkedNotes + "/" + guessedScaleNotes.size());
    }

}
