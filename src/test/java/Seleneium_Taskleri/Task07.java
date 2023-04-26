package Seleneium_Taskleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task07 extends TestBase {
// - http://szimek.github.io/signature_pad/ sayfasına gidiniz
// - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
//- Çizimden sonra clear butonuna basınız
//- Sayfayi kapatiniz


    @Test
    public void name() throws InterruptedException {
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(yaziTahtasi);

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-10,-10);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,10);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(10,0);
        }
        actions.release().build().perform();

        bekle(3);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();

    }


    }

