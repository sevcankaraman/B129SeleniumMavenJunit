package day_05_practise;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Files {

    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

    //"C:\Users\User\Desktop\text"


    @Test
    public void name() {
        String farkliKisim=System.getProperty("user.home");
        System.out.println(farkliKisim);

        String ortakKisim="\\Desktop\\text";
        System.out.println(ortakKisim);

        String dosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
