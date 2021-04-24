package edu.bsu.cs222.Jeopardy.Model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelParser {
    File jeopardyFile;

    public ExcelParser(File jeopardyFile){
        this.jeopardyFile = jeopardyFile;
    }

    public ArrayList<String> getData() throws IOException {
        ArrayList<String> contents = new ArrayList<>();
        FileInputStream file = new FileInputStream(jeopardyFile.getAbsolutePath());
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        for (Row nextRow : sheet) {
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) {
                fillContents(contents, cellIterator);
            }
        }
        return contents;
    }

    private void fillContents(ArrayList<String> contents, Iterator<Cell> cellIterator) {
        Cell cell = cellIterator.next();
        String cellContents;
        if(cell.getCellType() == CellType.NUMERIC){
            Double number = cell.getNumericCellValue();
            cellContents = differentiateIntAndDouble(number);
        }else{
            cellContents = cell.toString();
        }
        contents.add(cellContents);
    }

    private String differentiateIntAndDouble(Double number) {
        if(number % 1 == 0){
            return String.valueOf((int) Math.round(number));
        }else{
            return String.valueOf(number);
        }
    }
}