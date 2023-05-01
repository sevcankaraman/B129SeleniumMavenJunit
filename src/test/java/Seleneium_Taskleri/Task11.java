package Seleneium_Taskleri;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.*;

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
    private static String ortak = System.getProperty("user.home") + "/Desktop/data.xls";

    @Test
    public void writeExcel() throws IOException {

        //Yeni bir Excel Workbook nesnesi oluşturalım
        Workbook workbook = new XSSFWorkbook();

        //Workbook içine yeni bir çalışma sayfası ekleyelim
        Sheet sheet = workbook.createSheet("Sheet1");

        //Satır oluşturalım
        Row row = sheet.createRow(0);

        //Hücreyi olusturalım ve deger ataması yapalım
        Cell cell = row.createCell(0);
        cell.setCellValue("email");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("password");

        Row row1 = sheet.createRow(1);
        Cell cell2 = row1.createCell(0);
        cell2.setCellValue("evren.techproed@gmail.com");
        Cell cell3 = row1.createCell(1);
        cell3.setCellValue("asdfgh");

        //Dosyayı kaydetmek için fileinputstream kullanalım
        FileOutputStream fis = new FileOutputStream(ortak);
        workbook.write(fis);

        //Bellek yönetimi için kaynakları serbest bırakın
        fis.close();
        workbook.close();

        //Dosyanın basarıyla olusturuldugunu yazdır
        System.out.println("excel dosyası " + ortak + "adresinde basarıyla olusturulmustur");


    }

    @Test
    public void name() throws IOException {
        //        -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");

        //Login butonuna tıklarız
        WebElement loginButton=driver.findElement(By.xpath("(//*[@role='button'])[1]"));
        loginButton.click();
        bekle(2);


//        -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        //Email input locaterını alalım
        WebElement emailInput=driver.findElement(By.xpath("//*[@id='formBasicEmail']"));

        //pasword input locaterını alalım
        WebElement passwordInput=driver.findElement(By.xpath("//input[@id='formBasicPassword']"));

        //FileInputStream bir dosyadan veri okumak için kullnılır.inputStream değişkenine atanan nesne,
        //belirtilen dosyanın içeriğini okumamızı sağlar.
        FileInputStream inputStream=new FileInputStream(new File(ortak));

        //InputStream den verileri oku ve bunları XSSFWorkbook nesnesine yukler
        Workbook workbook=new XSSFWorkbook(inputStream);

        //XSSFWorkbook nesnesınden belırtılen indeksteki sayfa bilgilerini almak için kullanılır.
        //getSheetAt metodu, belegenın belirtilen indeksindeki veriyi alır.
        Sheet sheet=workbook.getSheetAt(0);

        String email=sheet.getRow(1).getCell(0).getStringCellValue();
        String password=sheet.getRow(1).getCell(1).getStringCellValue();

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        WebElement button =driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

//                -Login olduğumuzu doğrulayalım
        WebElement login=driver.findElement(By.id("dropdown-basic-button"));
        Assert.assertTrue(login.isDisplayed());


    }
}