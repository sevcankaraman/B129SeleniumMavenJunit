package day14_JavaFaker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HomeWork_Faker extends TestBase {


    @Test
    public void name() {

//        1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

//        2. “create new account” butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

//        3. “firstName” giris kutusuna bir isim yazin
       WebElement first= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
       Faker faker=new Faker();
       first.sendKeys(faker.name().firstName());

//        4. “surname” giris kutusuna bir soyisim yazin
        WebElement surname=driver.findElement(By.name("lastname"));
        surname.sendKeys(faker.name().lastName());

//        5. “email” giris kutusuna bir email yazin
        WebElement email=driver.findElement(By.name("reg_email__"));
        email.sendKeys(faker.internet().emailAddress());

//        6. “email” onay kutusuna emaili tekrar yazin
       // WebElement emailonay=driver.findElement(By.name("reg_email_confirmation__"));
        //emailonay.sendKeys(faker.internet().emailAddress());


//        7. Bir sifre girin
       WebElement sifre= driver.findElement(By.name("reg_passwd__"));
       sifre.sendKeys(faker.internet().password());

//        8. Tarih icin gun secin
        WebElement gun=driver.findElement(By.name("birthday_day"));
        gun.sendKeys(faker.number().digits(10));

//        9. Tarih icin ay secin
        WebElement ay=driver.findElement(By.name("birthday_month"));
        ay.sendKeys(faker.number().digits(31));

//        10. Tarih icin yil secin
        WebElement yil=driver.findElement(By.name("birthday_year"));
        ay.sendKeys(faker.number().digits(31));

//        11. Cinsiyeti secin
        WebElement cinsiyet=driver.findElement(By.name("sex"));
        cinsiyet.sendKeys("1990");

//        12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.


//        13. Sayfayi kapatin


    }
}
