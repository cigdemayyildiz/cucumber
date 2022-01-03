package step_definitions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import utils.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelTest {

    @Test
    public void test() throws IOException {
        String filePath = "src/test/resources/ExcelTest.xlsx";
        File file = new File(filePath); // converts excel file into the java object
        FileInputStream inputStream = new FileInputStream(file); // FileInputStream will open the file that we provided
        Workbook workbook = new XSSFWorkbook(inputStream); // it will save excel data into the workbook object
        Sheet sheet = workbook.getSheet("test"); // it will store specific sheet that we provided
        Row row = sheet.getRow(0); // it will keep the row data
        Cell cell = row.getCell(1); // it will store given cell data into this object
        System.out.println(cell.toString());

        cell.setCellValue(cell+"newtestdata"); // yukarida satiri hucresi verilmis olan datayi bir baska data ile degistirdik

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
    }

    @Test
    public void test1() throws IOException {
        String filePath = "src/test/resources/ExcelTest.xlsx";
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("years");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(0);
        //System.out.println(cell);

        double actualYear = Double.parseDouble(cell.toString());
        double expectedYear = 1994.0;
        double delta = 1e-15;
        Assert.assertEquals(expectedYear,actualYear,delta);

        cell.setCellValue(1983);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);

        System.out.println(cell);
    }

    @Test
    public void test2() throws IOException {
        String filePath = "src/test/resources/ExcelTest.xlsx";
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("years");
        int firsRow = sheet.getFirstRowNum();
        int lastRow = sheet.getLastRowNum();

        for (int i=firsRow; i<=lastRow; i++){
            Row row = sheet.getRow(i);
            int firstCell = row.getFirstCellNum();
            int lastCell = row.getLastCellNum();
            for (int k=firstCell; k<lastCell; k++){
                if (row.getCell(k)==null){ // eger ici bos olan bir hucre varsa
                    continue; // devam et. devam ettikten sonra tekrar for icine gidip k yi null olmaktan cikaracak
                    // daha sonra sout u execute edecek.
                }
                System.out.println(row.getCell(k));
            }
        }
    }

    @Test
    public void test3() throws IOException {
        String filePath = "src/test/resources/ExcelTest.xlsx";
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        // when we navigate to the row which has no any data, row object will not be instantiated.
        // that's why it will throw  NullPointerException when we use the row object
        // to store the data into the row which has no data, we should create row and cell first then store the data.
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("years");
        Row row = sheet.createRow(2);
        Cell cell = row.createCell(1);
        cell.setCellValue(2000);

        // bir sey create etmek istedigimizde file i guncellemek icin bu islemi yapmak zorundayiz
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);

        System.out.println(cell);
    }

    @Test
    public void testExcelUtils(){
        ExcelUtils.openExcelFile("ExcelTest","test");
        String str = ExcelUtils.getDataFromExcelFile(1,1);
        System.out.println(str); // test5
        ExcelUtils.setDataToExcelFile(1,2,"1999");
        List<String> rowData = ExcelUtils.getRowDataFromExcelFile(1); // sadece 1 satiri getiriyor
        System.out.println(rowData); // [test4, test5, 1999]
        System.out.println(ExcelUtils.getAllDataFromExcelFile()); // [[test1, test2newtestdata, test3], [test4, test5, 1999]]
    }
}
