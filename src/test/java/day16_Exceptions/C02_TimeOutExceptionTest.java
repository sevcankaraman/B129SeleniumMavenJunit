package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutExceptionTest extends TestBase {
    @Test
    public void name() {
        driver.get("https://www.techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
       //  WebElement searchBox= driver.findElement(By.name("s"));//findelement methodu implicitly waitle calısıyor
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("yanlıs locator")));
    }

    //TimeoutException explicit wait kullanımında web element bulunamadığı zaman alınır.


    @Test
    public void timeOutExcepitonTest2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));//org.openqa.selenium.TimeoutException
        //Locator doğru ama yeterli bekleme süresi olmadığı için TimeoutException alıyoruz.
        System.out.println(isTrue);

    }
}
        //textToBe ==>birinci parametresinde locater ı alıyor, ıkıncı parametre de beklenen degeri olmalı.

