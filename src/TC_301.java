
import Utility.BaseDriver;
import Utility.MyFunc;
import Utility.elementsBox;
import org.junit.Assert;
import org.junit.Test;
public class TC_301 extends BaseDriver {

    @Test
    public void test(){

        driver.get("https://shopdemo.e-junkie.com/");
        Utility.elementsBox elementsBox=new elementsBox();

        elementsBox.eBookAdd.click();

        driver.switchTo().frame(elementsBox.frame1);
        Assert.assertTrue("The product was not added to the cart.", MyFunc.ListContainsString(elementsBox.cartItems, "Demo eBook"));








    }





}

