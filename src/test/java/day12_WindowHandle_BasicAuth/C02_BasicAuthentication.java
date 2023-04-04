package day12_WindowHandle_BasicAuth;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_BasicAuthentication extends TestBase {
    /*
    Asagıdakı bılgılerı kullanarak authentication yapınız:

    Url      : https://the-internet.herokuapp.com/basic_auth
    username : admin
    password : admin

    bilgileri kullanarak basarılı gırısı doğrulayın

     */

    //authentication url : https://admin:admin@the-internet.herokuapp.com/basic_auth
    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/basic_auth adresine gidiniz
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //paragrafın "congratulations ıcerdıgını doğrulayınız
        String paragraf=driver.findElement(By.xpath("//p")).getText();
        assertTrue(paragraf.contains("Congratulations"));

    }

}
