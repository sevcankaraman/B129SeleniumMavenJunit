package day16_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class C03_NullPointerException {
    WebDriver driver;//her non primitive in default degeri nulldır
    Faker faker;
    Integer number;
    String name;

    @Test
    public void name() {

    driver.get("https://www.techproeducation.com/");//javalang.NullPointerException==>null degere sahip obje

    }

    @Test
    public void nullPointerExceptionTest2() {
        // faker = new Faker();

        System.out.println(faker.number().numberBetween(1, 10));//java.lang.NullPointerException

    }
    //null bir degerle işlem yaparsak null poınter exception alırız.
    @Test
    public void nullPointerExceptionTest3() {

        //number = 4;
        System.out.println(number + 6);//java.lang.NullPointerException

    }

    @Test
    public void nullPointerExceptionTest4() {

        //name = "Ali";
        System.out.println(name.charAt(0));//java.lang.NullPointerException

    }


}
