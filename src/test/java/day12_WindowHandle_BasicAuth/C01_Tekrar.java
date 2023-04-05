package day12_WindowHandle_BasicAuth;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {
       /*
https://www.techproeducation.com adresine gidiniz
Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
Tab 2'de https://www.google.com sayfasını açınız
Tab 3'te https://www.linkedin.com sayfasını açınız
techproeducation sayfasına geçiniz
youtube sayfasına geçiniz
linkedIn sayfasına geçiniz
 */

    @Test
    public void name() {

//    https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

//    Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());

//    Tab 2'de https://www.google.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");


 //    Sayfa başlığının "Google" olduğunu doğrulayınız
        Assert.assertEquals("Google",driver.getTitle());


//     Tab 3'te https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");


//      Sayfa başlığının "LinkedIn" içerdiğini doğrulayınız
        Assert.assertEquals("LinkedIn",driver.getTitle());


//    techproeducation sayfasına geçiniz
        switchToWindow(0);
        bekle(2);

//    youtube sayfasına geçiniz
        switchToWindow(1);
        bekle(2);

//    linkedIn sayfasına geçiniz
        switchToWindow(2);
        bekle(2);
//
    }
}