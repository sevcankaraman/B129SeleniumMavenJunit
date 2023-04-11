package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C04_ExplicitWait extends TestBase {
    /*
https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
Add tuşuna basın
"It's gone!" yazısını doğrulayın
 */


    @Test
    public void name() {
//        https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//        Remove tuşuna basın
        driver.findElement(By.xpath("//button[.='Remove']")).click();

//        "It's gone!" yazısını doğrulayın

        assertTrue(driver.findElement(By.id("message")).isDisplayed());
        // explicit wait kullanma gereği yoktur.Implicit wait yeterlidir.
        //explicit wait bazı ozel durumlar ıcın kullanılır.


    }
}
