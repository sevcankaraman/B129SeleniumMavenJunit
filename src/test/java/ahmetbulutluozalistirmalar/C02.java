package ahmetbulutluozalistirmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");

        //cookies cıkarsa kabul et butonuna bas

        //sayfada kac adet buton bulundugunu yazdırın
        List<WebElement> buttonlistesi=driver.findElements(By.tagName("button"));
        System.out.println(buttonlistesi.size());

        //sayfadakı her bır butonun  uzerındekı yazıları yazdırın

        for (WebElement w:buttonlistesi ) {
            System.out.println(w.getText());

        }
        driver.close();
    }
}
