package com.OrangeHRM.Utilities;

import java.util.Random;

public class Common {
    public static int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(99999 - 10000 + 10000);
    }
}
