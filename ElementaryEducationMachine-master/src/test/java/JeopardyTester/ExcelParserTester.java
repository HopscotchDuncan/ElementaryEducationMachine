package JeopardyTester;

import edu.bsu.cs222.Jeopardy.Model.ExcelParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelParserTester {
    File test = new File("C:\\Users\\Robert\\Documents\\JeopardyTest.xlsx");
    ExcelParser excelParser = new ExcelParser(test);

    @Test
    public void testGetData(){
        ArrayList<String> dataFromExcel = new ArrayList<>();
        dataFromExcel.add("Category");
        dataFromExcel.add("answer 200");
        dataFromExcel.add("question");
        dataFromExcel.add("answer 400");
        dataFromExcel.add("question");
        dataFromExcel.add("answer 600");
        dataFromExcel.add("question");
        dataFromExcel.add("answer 800");
        dataFromExcel.add("question");
        dataFromExcel.add("answer 1000");
        dataFromExcel.add("question");
        try {
            Assertions.assertEquals(dataFromExcel,excelParser.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
