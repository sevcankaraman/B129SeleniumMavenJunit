package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Tekrar extends TestBase {
    @Test
    public void name() {

        //    https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


//    Sayfanın alt tarafına gidin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
//    Sayfanın üst tarafına gidin
        actions.sendKeys(Keys.PAGE_UP).perform();
    }
}