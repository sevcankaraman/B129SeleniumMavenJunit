package Seleneium_Taskleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task05 extends TestBase {
//-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
// -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
//-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
//-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
//-Çıkan alert'te iptal butonuna basınız
// -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
//-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
//-Çıkan mesajı konsola yazdırınız
//-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız


    @Test
    public  void test01 (){
        driver.get("http://demo.automationtesting.in/Alerts.html");

        // -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement alert=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        alert.click();
        bekle(2);

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        bekle(2);
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        bekle(2);

       driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
       bekle(2);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        // -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("//*[text()='Alert with Textbox '] ")).click();
        bekle(2);
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("sevcan");
       bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);

        //-Çıkan mesajı konsola yazdırınız
        System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello sevcan How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());


    }
}
