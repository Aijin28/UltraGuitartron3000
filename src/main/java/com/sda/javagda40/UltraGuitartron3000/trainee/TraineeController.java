package com.sda.javagda40.UltraGuitartron3000.trainee;

import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.database.TraineeDao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TraineeController {
    public static Trainee choosingTrainee(Scanner SCANNER){
        EntityDao<Trainee> traineeEntityDao = new EntityDao<>();
        List<Trainee> traineeList = traineeEntityDao.findAll(Trainee.class);
        for (Trainee trainee : traineeList) {
            System.out.println(trainee.getId() +
                    ". Nazwa: " + trainee.getName());
        }
        System.out.println("Wybierz numer użytkownika z listy: ");
        int select = 0;
        try {
            select = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
        }
        boolean state = true;
        do {
            if (traineeEntityDao.findById(Trainee.class, select).isEmpty()){
                try {
                    System.out.println("Nie ma takiego użytkownika. Wybierz jeszcze raz.");
                    select = Integer.parseInt(SCANNER.nextLine());
                } catch (InputMismatchException | NumberFormatException ime) {
                    System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                    continue;
                }
                state = false;
            }else{
                return traineeEntityDao.findById(Trainee.class, select).get();
            }
        }while (!state);
        return new Trainee();
    }
}
