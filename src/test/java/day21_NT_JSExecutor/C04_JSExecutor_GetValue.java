package day21_NT_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutor_GetValue extends TestBase {
    @Test
    public void getValueTest() {

        //  1)https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        //  2)Tarih kısmındaki Yazili metinleri al ve yazdır
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement date= (WebElement) js.executeScript("return document.getElementById('checkin_date')");

        //js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
        //CSS selector ile yukarıdakı gibi locate alabılırsınız

        /*
        eger bır web sayfasında web elementler olusturulurken JS kullanılmıssa normal olarak locate almakta
        zorlanırız.
        Bu gıbı durumlarda yukarıdakı ornektekı gıbı js executor kullşarak web elementı locate edebılrız.
         */
        sendKeysJS(date,"5/25/2023");

        /*
        eger bır webelementin attribute değerini yazdırmak istersek asagıdakı gornektekı gıbı yaparız.
         */

        String attributeValue= (String) js.executeScript("return document.getElementById('checkin_date').value");
        System.out.println("Value Attribute Değeri = "+attributeValue);


    }
}
