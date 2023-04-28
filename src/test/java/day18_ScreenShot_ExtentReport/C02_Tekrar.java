package day18_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Tekrar extends TestBase {
    //Amazon sayfasına gidiniz
    //Arama bölümünde iphone aratınız
    //Sonuc yazısının resmini alınız

    @Test
    public void name() throws IOException {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Arama bölümünde iphone aratınız
       WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
       aramakutusu.sendKeys("iphone"+ Keys.ENTER);

        //Sonuc yazısının resmini alınız
        WebElement sonucyazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyayolu="testOutPut/screenshot"+tarih+"sevcan.png";
        FileUtils.copyFile(sonucyazisi.getScreenshotAs(OutputType.FILE),new File(dosyayolu));
    }
}
