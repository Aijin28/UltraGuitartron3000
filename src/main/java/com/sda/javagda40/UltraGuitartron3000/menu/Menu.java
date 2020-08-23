package com.sda.javagda40.UltraGuitartron3000.menu;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import com.sda.javagda40.UltraGuitartron3000.scales.ScalesController;
import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Optional<Trainee> userOptional;
    private Trainee user;
    EntityDao<Trainee> userDao = new EntityDao<>();

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startMainMenu() {
        boolean working = true;
        while (working) {
            System.out.println("Witaj w Ultra Guitartron 3000.\n" +
                    "_______________________________\n" +
                    "|         +M E N U+           |\n" +
                    "|   1.Wybierz użytkownika     |\n" +
                    "|   2.Utwórz użytkownika      |\n" +
                    "|   3.Zakończ                 |\n" +
                    "_______________________________\n");
            int select;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException ime) {
                System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                continue;
            }
            switch (select) {
                case 1:
                    System.out.println(userDao.findAll(Trainee.class));
                    System.out.println("Wybierz numer z listy: ");
                    try {
                        select = Integer.parseInt(scanner.nextLine());
                    } catch (InputMismatchException ime) {
                        System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                        continue;
                    }
                    userOptional = userDao.findById(Trainee.class, select);
                    userOptional.ifPresent(x -> user = x);
                    userMenu(user);
                    break;
                case 2:
                    System.out.println("Podaj nazwę nowego użytkownika: ");
                    String name;
                    //Nie daję try catch do scanner.nextLine(); bo z nim nie ma takich problemów jak z nextInt()
                    name = scanner.nextLine();
                    //Przydałoby się to poniższe obwarować, że jak próbujesz utworzyć nowego Trainee o name takim jak już jest w bazie danych, to że wyskakuje info, że nie możesz, bo taki użytkownik już istnieje, tymczasem jedyne wyskoczy to informacja "CHECKED"
                    userDao.saveOrUpdate(new Trainee(name));
                    userMenu(user);
                    break;
                case 3:
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
//            if (user.isAdminPermission()) {
//                ChordsController chordsController = new ChordsController();
//                ScalesController scalesController = new ScalesController();
//                EntityDao<Chords> chordsEntityDao = new EntityDao<>();
//                EntityDao<Scales> scalesEntityDao = new EntityDao<>();
                ChordsHandler chordsHandler = new ChordsHandler();
                ScalesHandler scalesHandler = new ScalesHandler(scanner);
                System.out.println("Co chcesz zrobić?\n" +
                        "1.Skale\n" +
                        "2.Akordy\n" +
                        "0.Koniec\n");
                try {
                    select = Integer.parseInt(scanner.nextLine());
                } catch (InputMismatchException|NumberFormatException ime) {
                    System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                    continue;
                }
                switch (select) {
                    case 1:
                        chordsHandler.handle();
                        break;
                    case 2:
                        scalesHandler.handle(user);
                        break;
                    case 0:
                        working = false;
                        break;
                    default:
                        System.out.println("NIE MA TAKIEJ OPCJI!");
                        break;
                }
//            } else {
//                ChordsController chordsController = new ChordsController();
//                ScalesController scalesController = new ScalesController();
//                EntityDao<Chords> chordsEntityDao = new EntityDao<>();
//                EntityDao<Scales> scalesEntityDao = new EntityDao<>();
//                System.out.println("Co chcesz zrobić?\n" +
//                        "1.Znajdź akord\n" +
//                        "2.Znajdź skalę\n" +
//                        "3.Ćwicz akord\n" +
//                        "4.Ćwicz skalę\n" +
//                        "5.Koniec\n");
//                try {
//                    select = scanner.nextInt();
//                } catch (InputMismatchException ime) {
//                    System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
//                    continue;
//                }
//                switch (select) {
//                    case 1:
//
//                    case 2:
////
//                        break;
//                    case 3:
//                        //dodać funkcję ćwiczenia akordu
//                        break;
//                    case 4:
//                        //dodać funkcję ćwiczenia skali
//                        break;
//                    case 5:
//                        working = false;
//                        break;
//                    default:
//                        System.out.println("NIE MA TAKIEJ OPCJI!");
//                        break;
//                }
//            }
        }
    }
}
