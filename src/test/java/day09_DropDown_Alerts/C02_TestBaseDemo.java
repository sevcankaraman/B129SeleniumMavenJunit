package day09_DropDown_Alerts;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {
    @Test
    public void Test01() {
        //Tecproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //baslığın "bootcamp" içerdiğni test edelim
        String actualTitle= driver.getTitle();
        String exceptedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(exceptedTitle));
    }
}
