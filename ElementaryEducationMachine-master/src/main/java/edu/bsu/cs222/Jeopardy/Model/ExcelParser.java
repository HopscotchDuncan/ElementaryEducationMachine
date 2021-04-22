package edu.bsu.cs222.Jeopardy.Model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelParser {
    File jeopardyFile;
    ArrayList<String> contents = new ArrayList<>();

    public ExcelParser(File jeopardyFile){
        this.jeopardyFile = jeopardyFile;
    }

    public ArrayList<String> getData() throws IOException {
        FileInputStream file = new FileInputStream(jeopardyFile.getAbsolutePath());
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        for (Row nextRow : sheet) {
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellContents = cell.toString();
                contents.add(cellContents);
            }
        }
        return contents;
    }
}