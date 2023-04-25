package day14_JavaFaker_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C04_Tekrar extends TestBase {
    @Test
    public void name() {
        //        "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //        "b10 all test cases" dosyasını indirin
        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();


        //        Dosyanın başarıyla indirilip indirilmediğini test edin.
        String dosya=System.getProperty("user.home")+"/Downloads/b10 all test cases, code (1).docx";
        boolean isExists=Files.exists(Path.of(dosya));
        assertTrue(isExists);


    }
}
