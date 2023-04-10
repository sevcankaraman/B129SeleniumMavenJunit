package day14_JavaFaker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_Tekrar {


    @Test
    public void name() {
        Faker faker = new Faker();
        Faker.instance().funnyName();
        System.out.println(faker.name().firstName());
        System.out.println(Faker.instance().name().lastName());
        System.out.println(faker.name().username());
        System.out.println(faker.funnyName());
        System.out.println(faker.name().title());
        System.out.println(faker.address().cityName());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.address().zipCode());
        System.out.println(faker.number().digits(15));


    }
}
