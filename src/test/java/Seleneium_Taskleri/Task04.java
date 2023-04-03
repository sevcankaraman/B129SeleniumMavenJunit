package Seleneium_Taskleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Task04 extends TestBase {

//-Amazon sayfasına gidelim
//-Arama Kutusundaki Dropdown menuyu yazdıralım
//-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
//başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
//Not: Select Class'ı kullanalım


    @Test
    public void Test01() {
        driver.get("https://amazon.com");

        Select select =new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
        for (WebElement w:select.getOptions()) {
            System.out.println(w.getText());

        }
        System.out.println("*****************************************************");
        int sayac=1;
        for (WebElement w: select.getOptions()) {
            Select option=new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            bekle(1);
            driver.navigate().back();
            bekle(1);
            sayac++;
            if (sayac>=6){
                break;
            }



        }
        driver.close();
    }
}
