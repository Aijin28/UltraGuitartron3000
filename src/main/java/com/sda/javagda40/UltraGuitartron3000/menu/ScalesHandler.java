package com.sda.javagda40.UltraGuitartron3000.menu;

import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import com.sda.javagda40.UltraGuitartron3000.scales.ScalesController;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScalesHandler {

    private final Scanner SCANNER;
    private ScalesController scalesController;
    EntityDao<Scales> scalesEntityDao = new EntityDao<>();
    private int select;

    public void handle() {
        boolean state = true;
        do{
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
                    //scale training
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
        scalesController.gettingScaleFromArray(scalesEntityDao.findById(Scales.class, selectedScale), scaleRootNote);
    }

    private void deleteScale(){
        int selectedScale = selectScale(scalesEntityDao);
        scalesEntityDao.delete(scalesEntityDao.findById(Scales.class, selectedScale).get());
    }

    public ScalesHandler(Scanner scanner) {
        this.SCANNER = scanner;
    }

}
