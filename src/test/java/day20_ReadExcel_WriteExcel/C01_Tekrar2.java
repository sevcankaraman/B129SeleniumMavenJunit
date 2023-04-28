package day20_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class C01_Tekrar2 {

    @Test
    public void name() throws IOException {

        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet("Sheet1");
        Row row=sheet.getRow(0);
        Cell cell=row.getCell(1);
        System.out.println(cell);
//    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın

//    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        Cell cell2=sheet.getRow(2).getCell(0);
        System.out.println(cell2);
        assertEquals("France",cell2.toString());


//    Kullanılan satır sayısın bulun
        int satirSayisi=cell2.getSheet().getPhysicalNumberOfRows();
        System.out.println(satirSayisi);

//    Ülke-Başkent şeklinde verileri yazdırın
        Map<String,String> ulkevebaskent=new HashMap<>();
        for (int satirindex = 1; satirindex <satirSayisi ; satirindex++) {
            String ulkeAdi= sheet.getRow(satirindex).getCell(0).toString();
            String BaskentAdi=sheet.getRow(satirindex).getCell(1).toString();
            ulkevebaskent.put(ulkeAdi,BaskentAdi);

        }
        System.out.println(ulkevebaskent);



    }
}
