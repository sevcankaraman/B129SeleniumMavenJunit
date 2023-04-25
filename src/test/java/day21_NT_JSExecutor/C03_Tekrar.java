package day21_NT_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Tekrar extends TestBase {
    @Test
    public void name() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramakutusu=driver.findElement(By.name("s"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'",aramakutusu);
        aramakutusu.submit();


    }
}
