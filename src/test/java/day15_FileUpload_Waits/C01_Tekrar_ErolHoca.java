package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class C01_Tekrar_ErolHoca extends TestBase {
    @Test
    public void name() throws AWTException {
        /*
        bir web sayfasında upload işlemı yapmamız gerekırse ;
        1-öncelikle upload edecegımız web elemntı locate ederiz
        2-upload edecegımız dosya yolunu bir stringe assign ederiz
        3-locate ettiğimiz web elemnte sendKeys metodu ile dosya yolunu aldığımız string değişkeni göndeririz.
         */

   // https://the-internet.herokuapp.com/upload adresine gidin
    driver.get("https://the-internet.herokuapp.com/upload");

 //   logo.jpeg dosyasını yükleyin(upload)

       WebElement logo= driver.findElement(By.id("file-upload"));
       bekle(3);
       String dosyayolu="\"C:\\Users\\User\\Desktop\\batch129.txt\"";

       //String dosyayolu=(System.getProperty("user.home")+("/Desktop/batch129.txt"));
        logo.sendKeys(dosyayolu);

   // “File Uploaded!” textinin görüntülendiğini test edin
        bekle(3);
        WebElement fileuploaded=driver.findElement(By.id("file-submit"));
        fileuploaded.click();


        WebElement text=driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        assertTrue(text.isDisplayed());

        //böyle de olur
       // Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());






    }
}
