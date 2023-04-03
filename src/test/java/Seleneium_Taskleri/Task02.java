package Seleneium_Taskleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task02 {
//    *** Aşağıdaki Task'i Junit framework'u ile yapınız
//- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
// - Add Element butonuna 100 defa basınız
//- 100 defa basıldığını test ediniz
//- 90 defa delete butonuna basınız
//- 90 defa basıldığını doğrulayınız
//- Sayfayı kapatınız
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    WebElement button=driver.findElement(By.xpath("//*[text()='Add Element']"));
    for (int i = 0; i < 100; i++) {
        button.click();
    }
    List<WebElement> deleteButton=driver.findElements(By.xpath("//button[text()='Delete']"));
    Assert.assertEquals(100,deleteButton.size());

    for (int i = 0; i < 90; i++) {
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
    }

    List<WebElement> deleteButtonList=driver.findElements(By.xpath("//button[text()='Delete']"));
    int kalanButton=deleteButton.size();
    Assert.assertEquals(kalanButton,deleteButtonList.size());

    driver.close();
}
}
