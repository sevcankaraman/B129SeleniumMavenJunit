package day21_NT_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {

    @Test
    public void name() {
//    Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();


//    We Offer elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
       WebElement weoffer= driver.findElement(By.xpath("//span[text()='we offer']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weoffer);
        tumSayfaResmi();

//    Aynı sayfada Enroll Free elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollfree=driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));

        js.executeScript("arguments[0].scrollIntoView(true);",enrollfree);
        tumSayfaResmi();


//    Aynı sayfada WHY US? elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyus= driver.findElement(By.xpath("//*[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true);",whyus);
        tumSayfaResmi();


//    Aynı sayfada tekrar Enroll Free elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al


        js.executeScript("arguments[0].scrollIntoView(true);",enrollfree);
        tumSayfaResmi();

    }
}
