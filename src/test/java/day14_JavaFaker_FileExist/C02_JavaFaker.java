package day14_JavaFaker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02_JavaFaker  {
    @Test
    public void javaFakerTest() {
        //1.Faker objesi olustur:
        Faker faker=new Faker();
        System.out.println(faker.pokemon().name());

        //Yada Faker.instance() static methodu ile başlayabiliriz
        Faker.instance().funnyName();

        //Firstname yazdırın:
        System.out.println(faker.name().firstName());

        //Lastname yazdırın:

        System.out.println(Faker.instance().name().lastName());

        //kullanıcı adı yazdırın

        System.out.println(faker.name().username());

        //funny name yazdırın

        System.out.println(faker.funnyName().name());

        //Meslek ismi yazdırın

        System.out.println(faker.name().title());

        //sehir ismi yazdırın

        System.out.println(faker.address().city());

        //full address yazdırın

        System.out.println(faker.address().fullAddress());

        //cep numarasını yazdırın

        System.out.println(faker.phoneNumber().cellPhone());

        //email yazdırın

        System.out.println(faker.internet().emailAddress());

        //posta kodu yazdırın

        System.out.println(faker.address().zipCode());

        //Rastgele 15 haneli bir numara yazdırın

        System.out.println(faker.number().digits(15));




    }
}
