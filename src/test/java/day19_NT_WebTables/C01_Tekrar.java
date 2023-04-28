package day19_NT_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_Tekrar extends TestBase {
    @Test
    public void name() {

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 1 : Table1’i yazdırın
        WebElement table1= driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table1.getText());


        //    Task 2 : 3. Satır verilerini yazdırın
        List<WebElement>  satir3 = driver.findElements(By.xpath("//tbody[1]/tr[3]//td"));
        satir3.forEach(t-> System.out.print(t.getText()+" - "));

        //    Task 3 : Son satırın verilerini yazdırın
        List <WebElement> satirSon=driver.findElements(By.xpath("//tbody[1]//tr[last()]"));
        satirSon.forEach(t-> System.out.print(t.getText()+ " - "));

        //    Task 4 : 5. Sütun verilerini yazdırın
        List <WebElement> sutun5=driver.findElements(By.xpath("//tbody[1]//td[5]"));
        sutun5.forEach(t-> System.out.println(t.getText()+" - "));

        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.


    }

    @Test
    public void name1() {
        driver.get("https://the-internet.herokuapp.com/tables");
        printData(1,2);
    }
}

