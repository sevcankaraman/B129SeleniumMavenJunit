package Seleneium_Taskleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task06_Tekrar extends TestBase {
    @Test
    public void name() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe=driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);


// ikinci emojiye tıklayın
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();




// İkinci emoji öğelerini yazdırınız
        List<WebElement> emojiler=driver.findElements(By.xpath("//div[@id='nature']"));

        for (WebElement w:emojiler ) {
            System.out.println(w.getText());

        }



// Parent iframe e geri donun
        driver.switchTo().defaultContent();



// Formu doldurun,(Formu istediğiniz metinlerle doldurun)


// Apply button a basiniz

    }
}