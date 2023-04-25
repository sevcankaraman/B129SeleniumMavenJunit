package day21_NT_JSExecutor;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {
    @Test
    public void name() {

//    http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");

//    Formu doldur
        Faker faker=new Faker();
        WebElement firstname=driver.findElement(By.id("firstname"));
        firstname.sendKeys(faker.name().lastName(),
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,"sevcan");


        //    Submit tuşuna tıkla
        WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
       // submit.submit();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",submit);

//    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on",driver.getCurrentUrl());

    }
}