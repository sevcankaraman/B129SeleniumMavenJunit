package ahmetbulutluozalistirmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_Assertion {
//    Test Case 1: Register User

//1. Launch browser

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully--anasayfanın basarılı bır sekılde gorunur oldugunu test edın
        WebElement logoElementi=driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

//4. Click on 'Signup / Login' button--
       WebElement login= driver.findElement(By.xpath( "//a[text()=' Signup / Login']"));
       login.click();

//5. Verify 'New User Signup!' is visible--logın to your accountu u test et-baglantı basarılı ıse gronur oldugunu test et
       WebElement loginYazisi= driver.findElement((By.xpath("//h2[text()='Login to your account']")));
       Assert.assertTrue(loginYazisi.isDisplayed());

//6. Enter name and email address--dogru kullanıcı adı ve sıfre--ahmet@nehaber.com -email / şifre 12345
       WebElement email=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
       email.sendKeys("ahmet@nehaber.com");

       WebElement password= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
       password.sendKeys("12345");



//7. Click 'Signup' button--logın butonuna basın

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible--loged in as ahmet ın basarılı bır sekılde gorunur oldugunu test edın
       WebElement logedYazisi= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
       Assert.assertTrue(logedYazisi.isDisplayed());


        //logout butonuna basın
        driver.findElement(By.xpath("//a[text()=' Logout']")).click();

        //anasayfasa geldıgınızı test edın
        String exceptedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(exceptedUrl,actualUrl);

        driver.close();


    }
//9. Fill details: Title, Name, Email, Password, Date of birth
//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//14. Verify that 'ACCOUNT CREATED!' is visible
//15. Click 'Continue' button
//16. Verify that 'Logged in as username' is visible
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
}
