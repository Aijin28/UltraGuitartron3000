package com.sda.javagda40.UltraGuitartron3000.menu;

import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;
import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private final Scanner SCANNER;
    EntityDao<Trainee> userDao = new EntityDao<>();
    private Trainee user;

    public Menu(Scanner SCANNER) {
        this.SCANNER = SCANNER;
    }

    public void startMainMenu() {
        boolean working = true;
        while (working) {
            System.out.println(
                    "-----------------------------------\n" +
                    "|           +U G T 3000+          |\n" +
                    "|      1.Wybierz użytkownika      |\n" +
                    "|      2.Utwórz użytkownika       |\n" +
                    "|      0.Zakończ                  |\n" +
                    "|                                 |\n" +
                    "-----------------------------------\n");
            int select;
            try {
                select = Integer.parseInt(SCANNER.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                continue;
            }
            switch (select) {
                case 1:
                    List<Trainee> userList = userDao.findAll(Trainee.class);
                    for (Trainee trainee : userList) {
                        System.out.println(trainee.getId() +
                                ". Nazwa: " + trainee.getName());
                    }
                    System.out.println("Wybierz numer z listy: ");
                    try {
                        select = Integer.parseInt(SCANNER.nextLine());
                    } catch (InputMismatchException ime) {
                        System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                        continue;
                    }
                    Optional<Trainee> userOptional = userDao.findById(Trainee.class, select);
                    userOptional.ifPresent(x -> user = x);
                    userMenu(user);
                    break;
                case 2:
                    System.out.println("Podaj nazwę nowego użytkownika: ");
                    String name;
                    name = SCANNER.nextLine();

                    Trainee addedUser = new Trainee(name);
                    userDao.saveOrUpdate(addedUser);
                    System.out.println("Dodano nowego użytkownika: " + addedUser.getName());
                    break;
                case 0:
                    System.out.println("Do widzenia!");
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    working = false;
                    break;
                default:
                    System.out.println("NIE MA TAKIEJ OPCJI!");
                    break;
            }
        }
    }

    public void userMenu(Trainee user) {
        boolean working = true;
        while (working) {
            int select;
            ChordsHandler chordsHandler = new ChordsHandler(SCANNER, user);
            ScalesHandler scalesHandler = new ScalesHandler(SCANNER, user);
            System.out.println(
                            "--------------------------------\n" +
                            "|           +M E N U+          |\n" +
                            "|      1.Akordy                |\n" +
                            "|      2.Skale                 |\n" +
                            "|      3.Usuń użytkownika      |\n" +
                            "|      4.Statystyki            |\n" +
                            "|      0.Powrót                |\n" +
                            "|                              |\n" +
                            "--------------------------------\n");
            try {
                select = Integer.parseInt(SCANNER.nextLine());
            } catch (InputMismatchException | NumberFormatException ime) {
                System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                continue;
            }
            switch (select) {
                case 1:
                    chordsHandler.handle();
                    break;
                case 2:
                    scalesHandler.handle();
                    break;
                case 3:
                    System.out.println("Użytkownik " + user.getName() + " został usunięty.");
                    userDao.delete(user);
                    working = false;
                    break;
                case 4:
                    System.err.println("Opcja niedostępna.");
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 0:
                    working = false;
                    break;
                default:
                    System.out.println("NIE MA TAKIEJ OPCJI!");
                    break;
            }
        }
    }
}
