package day21_NT_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Type extends TestBase {


//Techpro education ana sayfasina git
//Arama kutusuna QA yaz

    @Test
    public void name() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@title='Search']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        /*
        Bazı giriş kutuları normal  sendKeys () methodu ile veri gönderilmesine izin vermez.
        Bu gibi durumlarda asagıdakı örnektekı gıbi js executer kullanılır
        */
       // js.executeScript("arguments[0].value='QA'",aramaKutusu);
        //sendKeysJS(aramaKutusu,"QA");
        /*
        Eğer js.executeScript("arguments[0].value='QA'",aramaKutusu); bu kullanımdakı gibi  metin gönderemezsek
        asagıdakı ornektekı gıbı value attribute ine değer atayabılırız.
         */

        //js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
        sendAttributeJS(aramaKutusu,"QA");
        aramaKutusu.submit();




    }





}
