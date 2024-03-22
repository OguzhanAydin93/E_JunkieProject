package Utility;

import org.openqa.selenium.support.PageFactory;

public class elementsBox {

    public elementsBox(){
        PageFactory.initElements(Utlity.BaseDriver.driver, this);
    }


}
