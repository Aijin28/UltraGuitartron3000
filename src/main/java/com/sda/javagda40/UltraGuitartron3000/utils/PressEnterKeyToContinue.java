package com.sda.javagda40.UltraGuitartron3000.utils;

import java.io.IOException;

public class PressEnterKeyToContinue {

    public static void pressEnterKeyToContinue(){
        System.out.println("Naciśnij ENTER aby kontynuować ᓚᘏᗢ");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
