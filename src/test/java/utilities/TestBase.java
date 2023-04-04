package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    // TestBase class'ından obje olusturmanın önüne gecılmesı için abstract yapılabılır
    // orn: TestBase base=new TestBase()
    // Bu class 'ı extends ettiğimiz test classlarından ulasabılırız
    protected static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        // Thread.sleep(3000);
        //driver.quit();
    }

    // HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    //Alert TEXT
    public static void alertText() {
        driver.switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown Visibletext
     /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmvisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    // DropDown index
    public static void ddmindex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);

    }

    // DropDown value
    public static void ddmvalue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }
    //SwitchTo : sayfalar arası gecıs methodu
    //indeks 0 dan baslar
    //girilen indeksteki window handle degerını alarak o sayfaya gecıs yapar.

    public static void switchToWindow(int sayfaIndeksi){
        List<String> windowHandleList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(sayfaIndeksi));
    }
}