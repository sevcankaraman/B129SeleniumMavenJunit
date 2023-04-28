package Seleneium_Taskleri;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task11 extends TestBase {
 /*
    -İki tane test methodu oluşturalım
    -İlkinde masaüstünde java ile data.xlsx isimli bir dosya oluşturalım
    -Birinci satır birinci hücreye email ve ikinci hücreye password
    -ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım
    -Dosyayı kaydedelim
    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
    -Login olduğumuzu doğrulayalım
    */

    @Test
    public void writeExcel() throws IOException {

        Workbook workbook= new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");




        workbook.getSheet("Sheet1").createRow(0).createCell(0).setCellValue("E-mail");
       workbook.getSheet("Sheet1").createRow(1).createCell(0).setCellValue("emreonal12@gmail.com");
      workbook.getSheet("Sheet1").createRow(0).createCell(1).setCellValue("Password");
//        workbook.getSheet("Sheet1").createRow(1).createCell(1).setCellValue("Aslankral5241654163");

        FileOutputStream fos = new FileOutputStream("C:/Users/User/Desktop/data.xlsx");
        workbook.write(fos);

    }

    @Test
    public void login() {
        driver.get("https://www.bluerentalcars.com/");
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm']")).click();



    }
}