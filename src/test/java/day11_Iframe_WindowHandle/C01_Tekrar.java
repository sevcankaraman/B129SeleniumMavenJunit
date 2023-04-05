package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {
    /*
https://the-internet.herokuapp.com/iframe sayfasına gidiniz
Kalın yazının "Editor" kelimesimi içerdiğini doğrulayınız
Textbox içindeki yazıyı siliniz.
Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
 */

    @Test
    public void name() {

//        https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//        Kalın yazının "Editor" kelimesimi içerdiğini doğrulayınız
        String editorYazisi=driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(editorYazisi.contains("Editor"));


       WebElement iframe= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
       driver.switchTo().frame(iframe);


//        Textbox içindeki yazıyı siliniz.
      WebElement textBoxYazisi=  driver.findElement(By.xpath("//body[@id='tinymce']"));
      textBoxYazisi.clear();

//        Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.

        textBoxYazisi.sendKeys("Bu textbox iFrame içinde yer almaktadır");

//                Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.

        driver.switchTo().parentFrame();
      WebElement elemantal=  driver.findElement(By.linkText("Elemental Selenium"));
      Assert.assertTrue(elemantal.isDisplayed());

    }
}
