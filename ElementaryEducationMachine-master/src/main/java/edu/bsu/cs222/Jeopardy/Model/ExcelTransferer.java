package edu.bsu.cs222.Jeopardy.Model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelTransferer {

    public String getExcelData (int rowLocation, int columnLocation) throws IOException {
        File excelFile = new File("src/Jeopardy.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(rowLocation);
        Cell cell = row.getCell(columnLocation);
        fis.close();
        workbook.close();
        return cell.getStringCellValue();
    }
}
