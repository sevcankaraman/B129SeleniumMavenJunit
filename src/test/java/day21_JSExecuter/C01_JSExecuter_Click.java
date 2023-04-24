package day21_JSExecuter;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C01_JSExecuter_Click extends TestBase {

    /*
http://www.uitestpractice.com/Students/Form sayfasına git
Formu doldur
Submit tuşuna tıkla
Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
*/

    @Test
    public void clickByJSTest() {
//        http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");

//        Formu doldur
        driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());


//        Submit tuşuna tıkla
       WebElement submitButton= driver.findElement(By.xpath("//button[text()='Submit']"));
      //submitButton.click(); //ElementClickIntercepttedException ==> selenium click calısmadı: JSExecuter deniyorum

//            //Driverı javascriptexecuter classıan cast ediyoruz
//        JavascriptExecutor jse= (JavascriptExecutor) driver;
//
//        //executescript() metodu ile uygun scripti calıstırıyoru:
//        jse.executeScript("arguments[0].click();",submitButton);

        //clickByJS metodu olusturarak gerekli yerlerde tıklama yapabiliriz:

        clickByJS(submitButton); // TestBase classındaki clickByJS() metodu




//        Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        assertEquals("http://www.uitestpractice.com/Students/Form?",driver.getCurrentUrl());
//

    }
}
