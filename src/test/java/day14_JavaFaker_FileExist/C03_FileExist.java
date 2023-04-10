package day14_JavaFaker_FileExist;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C03_FileExist{
    /*
Masaüstünde "logo.jpeg" dosyası oluşturun.
Bu dosyanın varlığını doğrulayın.
*/
    @Test
    public void name() {

        String userDIR=System.getProperty("user.dir");
        //IDE proje yolunu dinamik olarak verir

        String userHOME=System.getProperty("user.home");
        //kullanıcı adı yolunu dınamık olarak verir.

       boolean isExist= Files.exists(Paths.get(userHOME+"/Desktop/logo.jpeg/"));
        System.out.println("is exist : "+ isExist);

        assertTrue(isExist);

        //C:\Users\User\IdeaProjects\B129SeleniumMavenJunit\src\test\java\day14_JavaFaker_FileExist\C03_FileExist.java





    }
}
