package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class TestBase {
    // TestBase class'ından obje olusturmanın önüne gecılmesı için abstract yapılabılır
    // orn: TestBase base=new TestBase()
    // Bu class 'ı extends ettiğimiz test classlarından ulasabılırız
    protected static WebDriver driver;
    @Before
    public void setUp() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //driver.quit();
    }
}
