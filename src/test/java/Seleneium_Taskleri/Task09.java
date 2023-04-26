package Seleneium_Taskleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Task09 extends TestBase {

    //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
//Click me, to open an alert after 5 seconds butonuna basalım
//Çıkan alert'i kapatalım

    @Test
    public void task09() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        //Click me, to open an alert after 5 seconds butonuna basalım
        WebElement waitButton = driver.findElement(By.xpath("//*[@id='alert']"));
        waitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        //Çıkan alert'i kapatalım
        driver.switchTo().alert().accept();
    }
}
