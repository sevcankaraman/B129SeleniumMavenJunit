package Seleneium_Taskleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class task01 extends TestBase {

    /*
    *** Aşağıdaki Task'i Junit framework'u ile yapınız
- ebay sayfasına gidiniz
- electronics bölümüne tıklayınız
- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
- Her sayfanın sayfa başlığını yazdıralım
- sayfayı kapatalım
     */

    @Test
    public void test01(){
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();

       List<WebElement> resimler= driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 0; i < resimler.size() ; i++) {
           resimler= driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            resimler.get(i).click();
            bekle(2);
            System.out.println(i+1+".baslık"+driver.getTitle());
            driver.navigate().back();
            driver.close();




        }

    }

}