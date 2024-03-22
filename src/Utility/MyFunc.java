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

    public static boolean ListContainsString(List<WebElement> list, String string) {
        boolean condition = false;
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(string))
                condition = true;
        }
        return condition;
    }
}
