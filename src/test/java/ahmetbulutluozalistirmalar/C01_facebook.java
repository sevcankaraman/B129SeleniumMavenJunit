package ahmetbulutluozalistirmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_facebook {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.facebook.com adresine gıdın
        driver.get("https://www.facebook.com");

        //cookies cıkarsa kabul et
        //driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();

        //e-posta kutusuna rastgele bir mail girin
        WebElement eposta= driver.findElement(By.xpath("//input[@id='email']"));
        eposta.sendKeys("srwerwerw");

        WebElement passwordkutusu= driver.findElement(By.xpath("//input[@id='pass']"));
        passwordkutusu.sendKeys("fsfdsfdsfsd");

        //giriş yap butonuna tıklayın
        driver.findElement(By.xpath("//button[@value='1']")).click();

        //uyarı mesajının cıktıgını test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedSonucYazisi="Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actuelSonucYazisi=sonucYazisi.getText();

        if (expectedSonucYazisi.equals(actuelSonucYazisi)){
            System.out.println("girilemedi testi passed");
        }else{
            System.out.println("girilemedi testi failed");
        }
        driver.close();









    }
}
