package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_Tekrar extends TestBase {
    //Window 1 de https://www.techproeducation.com adresine gidiniz
    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
    //Window 2'de https://www.youtube.com sayfasını açınız:
    //Window 3'te https://www.linkedin.com sayfasını açınız:
    //techproeducation sayfasına geçiniz:
    //youtube sayfasına geçiniz:
    //linkedIn sayfasına geçiniz:

    @Test
    public void name() {

        //Window 1 de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String w1=driver.getWindowHandle();
        bekle(2);

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String w2=driver.getWindowHandle();
        bekle(2);

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String w3=driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(w1);
        bekle(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(w2);
        bekle(2);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(w3);




    }


}
