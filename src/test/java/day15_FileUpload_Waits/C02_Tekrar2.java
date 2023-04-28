package day15_FileUpload_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_Tekrar2 extends TestBase {
    //https://the-internet.herokuapp.com/dynamic_loading/1
    //        Start buttonuna tıklayın
    //        Hello World! Yazının sitede oldugunu test edin


    @Test
    public void name() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test edin
        //Assert.assertTrue(driver.findElement(By.xpath("(//h4)[2]")).isDisplayed());

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
       WebElement text= driver.findElement(By.xpath("(//h4)[2]"));

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        Assert.assertTrue(text.isDisplayed());


    }
}
