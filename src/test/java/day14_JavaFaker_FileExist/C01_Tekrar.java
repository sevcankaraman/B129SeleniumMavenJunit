package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {
        /*
"https://techproeducation.com/" gidin
İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
 */

    @Test
    public void name() {

//        "https://techproeducation.com/" gidin

        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapattık burda

//        İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
        WebElement aramakutusu=driver.findElement(By.name("s"));
        Actions action=new Actions(driver);
        action.keyDown(aramakutusu,(Keys.SHIFT)).
                sendKeys("techpro").
                keyUp(Keys.SHIFT).
                sendKeys(" education",Keys.ENTER).
                build().
                perform();


    }

}
