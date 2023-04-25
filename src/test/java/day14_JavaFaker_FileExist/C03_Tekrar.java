package day14_JavaFaker_FileExist;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_Tekrar extends TestBase {
    @Test
    public void name() {


        //    Masaüstünde "logo.jpeg" dosyası oluşturun.
        //    Bu dosyanın varlığını doğrulayın.

        String logo =System.getProperty("user.home")+"/Desktop/logo.jpeg/";
        Assert.assertTrue(Files.exists(Paths.get(logo)));


    }
}