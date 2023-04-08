package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.apache.commons.io.FileUtils.waitFor;

public class Task_Odev extends TestBase {
    @Test
    public void iframeTest() {
        //● Bir metod olusturun: iframeTest
        //● https://the-internet.herokuapp.com/iframe adresine
        //gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement text=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println("text = " + text.getText());

        //○Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(0);
        WebElement inText=driver.findElement(By.xpath("//*[@id='tinymce']"));
        inText.clear();
        inText.sendKeys("Merhaba Dunya!");
        //waitFor(2);

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());
        System.out.println("frame inside text = " + driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());
    }}