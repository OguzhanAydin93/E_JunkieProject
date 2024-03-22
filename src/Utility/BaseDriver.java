package Utlity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

public class BaseDriver {

    public static Logger logTutma = LogManager.getLogger(); // Logları ekleyeceğim nesneyi başlattım.


    public static WebDriverWait wait;
    public static WebDriver driver;

    @BeforeClass
    public void BaslangicIslemleri() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // (web sayfasına özel 20 sn bekle)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // (Genel tüm WebElementler için 20 sn bekle)
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        LoginTest();
    }

    public void LoginTest() {
        System.out.println("Login Test başladı");
        logTutma.info("Log işlemi başladı");
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        MyFunc.bekle(1);

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("ozi@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("9517536");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']")); //By.cssSelector("[value='Login']")
        loginBtn.click();


        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertTrue(driver.getTitle().equals("My Account"));
        System.out.println("Login Test bitti");

        logTutma.info("Log işlemi tamamlandı"); // normal bir bilgi

        //legonun kapanması için- butonlar altına kalınca tıklatma yapılamıyor
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("bitnami-corner-image"))).perform();
        driver.findElement(By.id("bitnami-close-banner-button")).click();
    }


    @AfterClass
    public void KapanisIslemleri() {
        MyFunc.bekle(3);
        driver.quit();

        logTutma.info("Driver kapatıldı");
    }

    @BeforeMethod
    public void BeforeMetod() {
        logTutma.info("Metod başladı");

        logTutma.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
    }

    @AfterMethod
    public void AfterMetod(ITestResult sonuc) { // tesin sonuç ve isim bilgisini olduğu değişkeni
        logTutma.info(sonuc.getName() + " Metod bitti " + (sonuc.getStatus() == 1 ? "Passed" : "failed"));

        logTutma.warn("WARN : Metod bitti, hata oluşmuş olsa idi");
    }

}





