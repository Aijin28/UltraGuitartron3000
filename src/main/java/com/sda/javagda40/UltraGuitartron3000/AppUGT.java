package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.utils.Notes;

public class AppUGT {

    public static void main(String[] args) {
        Notes c = new Notes("C");
        EntityDao<Notes> appUserEntityDao = new EntityDao<>();
        appUserEntityDao.saveOrUpdate(c);
    }
}
