package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {
    @Test
    public void name() {

//➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


//➢ Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin   oldugunu test edelim
     String text=driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(text.contains("black border:"));

//➢ Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim

        driver.switchTo().frame(0);
        String aplication=driver.findElement(By.xpath("//h1[text()='Applications lists']")).getText();
        Assert.assertTrue(aplication.contains("Applications lists"));

//➢ Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        driver.switchTo().defaultContent();
        String footer=driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        Assert.assertTrue(footer.contains("Povered By"));

}
}