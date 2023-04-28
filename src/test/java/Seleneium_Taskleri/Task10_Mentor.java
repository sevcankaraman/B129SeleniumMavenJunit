package Seleneium_Taskleri;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Task10_Mentor extends TestBase {

    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;




    @Test
    public void task10() throws IOException {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYoluReports = "TestOutput/reports/extentReport_" + tarih + ".html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYoluReports);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test","Erol");
        extentReports.setSystemInfo("Adana","Urfa");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest = extentReports.createTest("ExtentTest","Test Raporu");
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.navigate().to("https://www.selenium.dev/downloads");
        extentTest.info("Selenium.dev sayfasina gidildi.");

        //Sayfanın resmini alalım
        String dosyaYolu = "TestOutput/screenshot/screenshot"+tarih+"tumsayfa.png";
        TakesScreenshot tss = (TakesScreenshot) driver;
        File screenShot = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(dosyaYolu));
        extentTest.info("Tum Sayfa Ekran görüntüsü alındı");


        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browser = driver.findElement(By.xpath("(//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
        actions.moveToElement(browser).perform();
        browser.click();
        extentTest.info("WebElement görünene kadar sayfa aşağıya kaydırıldı.");

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        extentTest.info("İstenilen linke tiklandi");


        //Documentation webelementinin resmini alalım
        WebElement chromDriverDocumentation = driver.findElement(By.xpath("//*[text()='ChromeDriver Documentation']"));
        String dosyaYolu1 = "TestOutput/screenshot/screenshot"+tarih+"element.png";
        FileUtils.copyFile(chromDriverDocumentation.getScreenshotAs(OutputType.FILE), new File(dosyaYolu1));
        extentTest.info("Webelement resmi alindi");

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("//*[text()='ChromeDriver 112.0.5615.49']")).click();
        extentTest.info("İstenilen linke tiklandi");

        //Açılan pencerede chromedriver'i indirelim
        //ChromeDriver'ı indirebilmem için kontrolüm dışında açılan sayfaya driver'ımı geçirmem gerekiyor.

        Set<String> windowHandles = driver.getWindowHandles();
        String ilkSayfaHandle = driver.getWindowHandle();

        for (String w : windowHandles) {
            if (!w.equals(ilkSayfaHandle)){
                driver.switchTo().window(w);
                extentTest.info("Driver, açılan yeni sayfaya geçirildi");
            }
        }

        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();

        //Driver'in indiğini doğrulayalım

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "/Downloads/chromedriver_win32.zip";
        String dosyaYolu2 = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
        extentTest.info("İndirilen dosyanın varlığı test edildi");
        //"C:\Users\User\Downloads\chromedriver_win32.zip"

        //İndirmiş olduğumuz dosyayı silelim
        File silinecek = new File(dosyaYolu2);
        silinecek.delete();
        extentTest.info("Dosya silindi.");

        //Silindiğini doğrulayalım
        Assert.assertTrue(Files.notExists(Paths.get(dosyaYolu2)));
        extentTest.info("Silinen dosyanın silinip-silinmediği test edildi");

        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
        extentReports.flush();





    }
}

