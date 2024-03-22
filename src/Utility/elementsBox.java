package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class elementsBox {

    public elementsBox(){
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "(//button[@class='view_product'])[2]")
    public WebElement eBookAdd;

    @FindBy(css = "[class='EJIframeV3 EJOverlayV3']")
    public WebElement frame1;

    @FindBy(css = "input[class='Promo-Code-Value']")
    public WebElement promoCode;

    @FindBy(xpath = "//button[text()='Apply']")
    public WebElement apply;

    @FindBy(css = "div[class='Col2 Product-Desc']>h5")
    public List<WebElement> cartItems;




}
