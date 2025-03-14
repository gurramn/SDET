package utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConfigExcelDataProvider {
    XSSFWorkbook wb;
    public ConfigExcelDataProvider(){
        try(FileInputStream fos = new FileInputStream("./Data/testdata.xlsx")) {
            wb = new XSSFWorkbook(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getStringData(String sheetName, int rowNum, int colNum){
        return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
    }

    public double getNumericData(String sheetName, int rowNum, int colNum){
        return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
    }
}
