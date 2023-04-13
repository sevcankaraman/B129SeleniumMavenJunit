package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void name() {
        driver.get("https://www.techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum
        driver.findElement(By.name("s")).sendKeys("QA"+ Keys.ENTER);

    }
}
