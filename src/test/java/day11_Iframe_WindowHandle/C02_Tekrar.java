package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class C02_Tekrar extends TestBase {
     /*
    https://the-internet.herokuapp.com/windows adresine gidin.
    İlk sayfanın ID'sini alın.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    "Click Here" butonuna tıklayın.
    Açılan pencereye geçin.
    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
    2. pencereye tekrar geçin.
    1. pencereye tekrar dönün.
     */

    @Test
    public void name() {
       // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//        İlk sayfanın ID'sini alın.
       String ilksayfaHandle= driver.getWindowHandle();
        System.out.println(ilksayfaHandle);

//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text=driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        Assert.assertEquals("Opening a new window",text.getText());

//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String sayfaBasligi=driver.getTitle();
       Assert.assertTrue(sayfaBasligi.contains("The Internet"));

       // "Click Here" butonuna tıklayın.
        driver.findElement(By.linkText("Click Here")).click();
        bekle(2);

      //  Açılan pencereye geçin.
        Set<String> allWindowHandle=driver.getWindowHandles();
        System.out.println(allWindowHandle);

        for (String w: allWindowHandle){
            if (!w.equals(ilksayfaHandle)){
                driver.switchTo().window(w);

            }
        }

      //  Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın

        Assert.assertEquals("New Window",driver.getTitle());

        String ikinciSayfa=driver.getWindowHandle();

       // Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.

        bekle(2);
        driver.switchTo().window(ilksayfaHandle);

        Assert.assertEquals("The Internet",driver.getTitle());


      //  2. pencereye tekrar geçin.

        driver.switchTo().window(ilksayfaHandle);

        bekle(2);

       // 1. pencereye tekrar dönün.

        driver.switchTo().window(ikinciSayfa);










    }
}
