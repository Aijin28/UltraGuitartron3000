package com.sda.javagda40.UltraGuitartron3000.database;

import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

public class TraineeDao {
    public static void fillingUsers(){
        EntityDao<Trainee> traineeEntityDao = new EntityDao<>();
        Trainee admin = new Trainee("admin", true);
        traineeEntityDao.saveOrUpdate(admin);
        Trainee user = new Trainee("user");
        traineeEntityDao.saveOrUpdate(user);
    }
}
