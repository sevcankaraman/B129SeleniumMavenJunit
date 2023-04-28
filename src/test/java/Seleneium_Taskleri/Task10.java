package Seleneium_Taskleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task10 extends TestBase {
    @Test
    public void name() throws InterruptedException {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browser = driver.findElement(By.xpath("(//p//button)[81]"));
        actions.moveToElement(browser).build().perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        Thread.sleep(1000);

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[4]")).click();
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));

        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
        Thread.sleep(10000);

        //Driver'in indiğini doğrulayalım
        //"C:\Users\Lenovo\Downloads\chromedriver_win32.zip"
        String dosyaYolu = System.getProperty("user.home")+"/Downloads/chromedriver_win32.zip";
        assert Files.exists(Paths.get(dosyaYolu));
        Thread.sleep(2000);
        File file = new File(dosyaYolu);
        if (Files.exists(Paths.get(dosyaYolu))){
            file.delete();
        }else System.out.println("Dosya yok");
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));

    }
}
