package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
public class ExcelDataReader {
    // Method to read data from Excel
    public Map<String, String> readExcelData(String excelFilePath, String sheetName, int rowNum) throws Exception {
        Map<String, String> rowData = new HashMap<>();
        try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0); // Assuming first row contains headers
            Row dataRow = sheet.getRow(rowNum); // Row number passed dynamically
            for (Cell cell : headerRow) {
                String header = cell.getStringCellValue();
                Cell dataCell = dataRow.getCell(cell.getColumnIndex());
                String cellValue = dataCell != null ? dataCell.toString() : "";
                rowData.put(header, cellValue);
            }
        }
        return rowData;
    }
}