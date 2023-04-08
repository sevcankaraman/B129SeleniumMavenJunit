package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {
    @Test
    public void name() {
//        Amazon anasayfasına gidin
        driver.get("https://amazon.com");

//        "Account & List" üzerinde bekleyin (mouse over - hover over)
       WebElement accountAndList= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountAndList).perform();


//        Açılan menüde "Account" linkine tıklayın
        driver.findElement(By.linkText("Account")).click();

//        Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
        String baslik=driver.getTitle();
        Assert.assertEquals("Your Account",baslik);


    }
}
