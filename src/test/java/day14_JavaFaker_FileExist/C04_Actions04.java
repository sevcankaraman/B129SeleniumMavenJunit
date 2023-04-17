package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
    /*
https://jqueryui.com/droppable/ adresine gidin
"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
 */

    @Test
    public void name() {

//    https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //sayfada iframe oldugu için "switch" yapıyoruz.
        driver.switchTo().frame(0);

        //Kaynak ve hedef web elementlerını locate edıyoruz
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);
        bekle(2);
        actions.dragAndDrop(source,target).perform();//dragAndDrop() methodu kaynak elemanı hedef eleman üzerine bırakır.


    }

    @Test
    public void name2() {
        //    https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //sayfada iframe oldugu için "switch" yapıyoruz.
        driver.switchTo().frame(0);

        //Kaynak ve hedef web elementlerını locate edıyoruz
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);
        bekle(2);
        actions.
                clickAndHold(source).//web elemnti tıklar ve tutar
                moveToElement(target).//mouse u bır element uzerıne tasır
                release().//tıklanıp tutulan mouse u bırakır
                perform();

        ////Burada dragAndDrop'tan farklı olarak işlemleri kendimiz sırayla belirttik.

    }
    @Test
    public void name3() {

//    https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //sayfada iframe oldugu için "switch" yapıyoruz.
        driver.switchTo().frame(0);

        //Kaynak ve hedef web elementlerını locate edıyoruz
        WebElement source= driver.findElement(By.id("draggable"));


        Actions actions = new Actions(driver);
        actions.
                clickAndHold(source).
                moveByOffset(388, 34).//moveByOffset methodu ile isteğimiz koordinata elementimizi taşıyabiliriz.
                release().
                build().
                perform();
    }
}

