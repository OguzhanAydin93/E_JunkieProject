package Utility;

import org.openqa.selenium.WebElement;


import java.util.List;

public class MyFunc {


    public static void bekle(int sn){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static int RandomGenerator(int max, int min) {
        return (int) (Math.random() * (max - min + 1));
    }

    public static boolean ListContainsString(List<WebElement> list, String aranacak){
        boolean bulundu=false;
        for (WebElement e: list)
        {
            if (e.getText().toLowerCase().equals(aranacak.toLowerCase()))
                bulundu=true;
        }

        return bulundu;
    }
}
