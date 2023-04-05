package day12_WindowHandle_BasicAuth;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {
      /*
    Asagıdakı bılgılerı kullanarak authentication yapınız:

    Url      : https://the-internet.herokuapp.com/basic_auth
    username : admin
    password : admin

    bilgileri kullanarak basarılı gırısı doğrulayın

     */

    //authentication url : https://admin:admin@the-internet.herokuapp.com/basic_auth


    @Test
    public void name() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //paragrafın "congratulations ıcerdıgını doğrulayınız
        WebElement paragraf=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraf.getText().contains("Congratulations"));
    }
}
