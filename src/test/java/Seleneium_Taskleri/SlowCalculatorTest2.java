package Seleneium_Taskleri;
import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class SlowCalculatorTest2 extends TestBase {


        private WebDriver driver;
        private Random random;

        @Test
        public void testSlowCalculator() {
            // URL'ye git
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

            // İki basamaklı random sayılar seç
            int num1 = random.nextInt(90) + 10; // 10-99 arası rastgele sayı
            int num2 = random.nextInt(90) + 10;

            // Rastgele işlem seç
            String[] operators = {"+", "-", "*", "/"};
            String operator = operators[random.nextInt(4)];

            // Hesaplamaları yap
            WebElement num1Input = driver.findElement(By.id("number1"));
            num1Input.sendKeys(String.valueOf(num1));

            WebElement num2Input = driver.findElement(By.id("number2"));
            num2Input.sendKeys(String.valueOf(num2));

            WebElement operatorSelect = driver.findElement(By.id("operator"));
            operatorSelect.sendKeys(operator);

            WebElement calculateButton = driver.findElement(By.id("calculate"));
            calculateButton.click();

            WebElement result = driver.findElement(By.id("result"));
            String expectedResult = calculate(num1, num2, operator);
            String actualResult = result.getText();

            // Sonucu kontrol et
            assertEquals(expectedResult, actualResult);
        }

        private static String calculate(int num1, int num2, String operator) {
            switch (operator) {
                case "+":
                    return String.valueOf(num1 + num2);
                case "-":
                    return String.valueOf(num1 - num2);
                case "*":
                    return String.valueOf(num1 * num2);
                case "/":
                    return String.valueOf(num1 / num2);
                default:
                    throw new IllegalArgumentException("Geçersiz işlem: " + operator);
            }
        }
    }

