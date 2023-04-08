package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task_Odev_Tekrar extends TestBase {
    @Test
    public void name() {
        //● Bir metod olusturun: iframeTest
//● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

//○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    WebElement text=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isEnabled());
        System.out.println("text"+text.getText());

//○Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(0);
        WebElement yazi=driver.findElement(By.xpath("//p"));
        yazi.clear();
        yazi.sendKeys("Merhaba Dünya");


//○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement link=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(link.isDisplayed());
        System.out.println("link:"+link.getText());


    }
}