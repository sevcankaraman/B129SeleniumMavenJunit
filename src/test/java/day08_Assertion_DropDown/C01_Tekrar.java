package day08_Assertion_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_Tekrar {
    /*
1)https://amazon.com adresine gidin
2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
    ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
    ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
*/
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void titleTest() {
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

    }

    @Test
    public void imageTest() {
       WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
       Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void SearchBox() {
        WebElement aramaKtusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue( aramaKtusu.isEnabled());

    }

    @Test
    public void wrongTitleTest() {
        Assert.assertFalse("Gercek Baslık Amazon",driver.getTitle().contains("amazon"));

    }
}

