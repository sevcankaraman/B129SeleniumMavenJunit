package Seleneium_Taskleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task06 extends TestBase {


    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// ikinci emojiye tıklayın
// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz

    @Test
    public void test01(){
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement ikinciButon=driver.findElement(By.xpath("//*[@id='tooltip-6i3gp']"));
        driver.switchTo().frame(ikinciButon);
    }

}
