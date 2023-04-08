package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
    @Test
    public void name() {

//    https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));

//    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,target).perform();


    }
}
