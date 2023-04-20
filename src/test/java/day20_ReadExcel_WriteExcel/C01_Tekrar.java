package day20_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class C01_Tekrar {

//
//    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
//    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
//    Kullanılan satır sayısın bulun
//    Ülke-Başkent şeklinde verileri yazdırın

    @Test
    public void excelRead() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell);
    }

    @Test
    public void name() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0).toString());

    }

    @Test
    public void readExcelTest3() throws IOException {

        //    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1).toString());


//    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3sutun1);
        assertEquals("France", satir3sutun1);


//    Kullanılan satır sayısın bulun
        System.out.println("son satır sayısı = " + workbook.getSheet("Sheet1").getLastRowNum());//excel tablosundakı son satır sayısını  verdı
        System.out.println("kullanılan satır sayısı =" + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        System.out.println("son sütun sayısı = " + workbook.getSheet("Sheet1").getRow(1).getLastCellNum());
        System.out.println("Kullanılan sutun sayısı = " + workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells());


//    Ülke-Başkent şeklinde verileri yazdırın
        Map<String, String> ulkeVeBaskentleri = new HashMap<>();
        for (int indeks = 1; indeks < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); indeks++) {
            String ulke = workbook.getSheet("Sheet1").getRow(indeks).getCell(0).toString();
            String baskent = workbook.getSheet("Sheet1").getRow(indeks).getCell(1).toString();
            ulkeVeBaskentleri.put(ulke, baskent + "\n");
        }
        System.out.println("ulkeVeBaskentleri = " + ulkeVeBaskentleri);

    }

    @Test
    public void readExcelTest4() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        for (int i = 1; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
                
            }
            System.out.println();

        }
    }
}