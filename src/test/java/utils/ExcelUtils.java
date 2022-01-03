package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

     /*
    open file
    get data
    set data
    get row data
    get all data
    */

    private static Workbook workbook;
    private static Sheet sheet;
    private static Row row;
    private static Cell cell;
    private static String path;

    // open file
    public static Sheet openExcelFile(String fileName, String sheetName) {
        path = "src/test/resources/" + fileName + ".xlsx";
        File file = new File(path);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " not found in given file location");
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    // get data
    public static String getDataFromExcelFile(int rowNum, int cellNum){
        return sheet.getRow(rowNum).getCell(cellNum).toString(); // sout yazsaydik toString(); methodunu java otomatik ekleyecekti ama bu sekilde return olarak yazdigimizda belirtmemiz gerekiyor.
    }


    // set data
    public static void setDataToExcelFile(int rowNum, int cellNum, String data){
        row = sheet.getRow(rowNum);
        if (row == null){
            row = sheet.createRow(rowNum);
        }

        cell = row.getCell(cellNum);
        if (cell == null){
            cell = row.createCell(cellNum, CellType.STRING);
        }

        cell.setCellValue(data);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Path "+path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    it will return the all cell values from given row number
     @param rowNum
     @return all cell values
     */

    // get row data
    public static List<String> getRowDataFromExcelFile(int rowNum){
        List<String> cells = new ArrayList<>();
        row = sheet.getRow(rowNum);
        int firstCell = row.getFirstCellNum();
        int lastCell = row.getLastCellNum();
        for (int i=firstCell; i<lastCell; i++){
            if (row.getCell(i) != null) {
                cells.add(row.getCell(i).toString());
            }
        }
        return cells;
    }

    /*
    it will return all the data from excel sheet
     */

    // get all data
    public static List<List<String>> getAllDataFromExcelFile(){
        List<List<String>> allData = new ArrayList<>();
        int firstRow = sheet.getFirstRowNum();
        int lastRow = sheet.getLastRowNum();
        for (int i=firstRow; i<=lastRow; i++){
            if (sheet.getRow(i) != null){
                allData.add(getRowDataFromExcelFile(i));
            }
        }
        return allData;
    }
}
