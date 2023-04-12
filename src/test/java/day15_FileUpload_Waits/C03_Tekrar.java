package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C03_Tekrar extends TestBase {

    @Test
    public void name() {

        //        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//   Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        // Hello World! Yazının sitede oldugunu test edin
        //Fluent wait in webdriverwaitten farkı wait objesinin olusturulmasında ortaya cıkar

        Wait<WebDriver> wait=new FluentWait<>(driver).
                            withTimeout(Duration.ofSeconds(30)). //fluent wait için max.süreyi belirler
                            pollingEvery(Duration.ofSeconds(3)).//her 3 saniyede bir webelementi kontrol eder.
                            withMessage("Ignore Exception").//zorunlu değil
                            ignoring(NoSuchElementException.class);//zorunlu değil exceptionu handle eder

        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

        assertTrue(helloWorldText.isDisplayed());
        /*
        Thread.Sleep: Javadan gelen bu bekleme ile belirttiğimiz süre kadar kodları bekletir
        Implictly Wait: Sayfadaki tüm webelementler için max süre kadar sayfanın yüklemesini bekler
        Explict Wait: Belirli bir koşul gerçekleşene kadar belirttiğimiz süre boyunca driver'ın beklemesini sağlar
        Fluent Wait: Belirli bir koşul gerçeklesene kadar belirttiğimiz aralıklarla beklemeye devam eder
         */






    }
}
