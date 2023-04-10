package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_Actions extends TestBase {
    /*
"https://techproeducation.com/" gidin
İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
 */

    @Test
    public void name() {
        //"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapattık burda


        //İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
       WebElement search= driver.findElement(By.xpath("//input[@name='s']"));
        Actions actions=new Actions(driver);
        actions.
                keyDown(search,Keys.SHIFT).//arama kutusu üzerinde SHIFT tusuna basılı tut
                sendKeys("techpro").//SHIFT basılı sekılde "techpro" yazısını gönder
                keyUp(Keys.SHIFT).//SHIFT tusuna basma işlemını sonlandır
                sendKeys(" education",Keys.ENTER).//SHIFT tuşuna basmadan "education" kelimesini yolla ve ENTER tuşuna bas
                build().
                perform();
    }
}
