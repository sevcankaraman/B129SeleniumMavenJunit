package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {
    @Test
    public void name() {


//    https://the-internet.herokuapp.com/context_menu  sitesine gidi
        driver.get("https://the-internet.herokuapp.com/context_menu");
//    Kutuya sağ tıklayın
        Actions actions=new Actions(driver);
       WebElement kutu= driver.findElement(By.id("hot-spot"));
        actions.contextClick(kutu).perform();

//    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
       String alert= driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alert);
//    Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }
}