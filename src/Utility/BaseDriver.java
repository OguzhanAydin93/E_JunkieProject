package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

public class BaseDriver {


    public static WebDriverWait wait;
    public static WebDriver driver;
    public static Actions actions;
    public static JavascriptExecutor js;



    static {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void BekleVeKapat() {
        Utility.MyFunc.bekle(3);
        driver.quit();
    }




}





