package day12_WindowHandle_BasicAuth;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Tekrar extends TestBase {
    @Test
    public void name() {
//  1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

//  2-tum cookie'leri listeleyin
        Set<Cookie> allCookies=driver.manage().getCookies();
        allCookies.stream().forEach(t-> System.out.println(t));


//  3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int tumCookieSayisi= allCookies.size();
        System.out.println(tumCookieSayisi);//8
        Assert.assertTrue(allCookies.size()>5);



//  4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String cookieValues=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",cookieValues);


//  5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        System.out.println(driver.manage().getCookies().size());


//  6-eklediginiz cookie'nin sayfaya eklendigini test edin
        String eklenenCookie=driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals("cikolatali",eklenenCookie);




//  7-ismi skin olan cookie'yi silin ve silindigini test edin
        int silmedenonce=driver.manage().getCookies().size();
        driver.manage().deleteCookieNamed("skin");
        int sonra=driver.manage().getCookies().size();
        Assert.assertEquals(1,silmedenonce-sonra);

//  8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Assert.assertEquals(0,driver.manage().getCookies().size());



    }



}
