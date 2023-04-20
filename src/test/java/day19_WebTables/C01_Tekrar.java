package day19_WebTables;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
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

        WebElement tablo1=driver.findElement(By.id("table1"));
        System.out.println("tablo1 = "+tablo1.getText());

        //Tüm Elementleri yazdırın.

        List<WebElement>tumElementler=driver.findElements(By.xpath("//table[@id='table1']//td"));

        tumElementler.forEach(t-> System.out.print(t.getText()));

        //    Task 2 : 3. Satır verilerini yazdırın

        List<WebElement> satir3=driver.findElements(By.xpath("//table[@id='table1']//tr[3]/td"));
        satir3.forEach(t-> System.out.println(t.getText()+"==>"));


        //    Task 3 : Son satırın verilerini yazdırın

        List<WebElement>sonSatir=driver.findElements(By.xpath("//table[@id='table1']//tr[last()]//td"));
        sonSatir.forEach(t-> System.out.print(t.getText()+ "==>"));

        //    Task 4 : 5. Sütun verilerini yazdırın

        List<WebElement>sutun5=driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        sutun5.forEach(t-> System.out.println(t.getText()+"==>"));

//    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData

    // YAPAMADIM SOR BU KISMI




//    Parameter 1 = satır numarası
//    Parameter 2 = sütun numarası
//    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.


















    }
}
