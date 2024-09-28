package ExcelToJsonConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class E2JConverter_CreateItem {

    public static Workbook workbook;
    public static Row row;

    public static JSONObject readExcelData(String excelFilePath) throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Map<String, String> data = new HashMap<>();
        row = sheet.getRow(1); // Read the first data row (assuming the first row is headers)
        for (Cell cell : row) {
            int columnIndex = cell.getColumnIndex();
            String header = sheet.getRow(0).getCell(columnIndex).getStringCellValue();
            String cellValue = cell.toString();
            data.put(header, cellValue);
        }
        workbook.close();
        fis.close();
        return createItem(data);
    }
    private static JSONObject createItem(Map<String, String> data) throws IOException {
        JSONObject json_createItem = new JSONObject();

        json_createItem.put("id_int", data.get("id_int")); //data.get("id_int") is for reading value from excel by passing header
        json_createItem.put("name", row.getCell(1).getStringCellValue());
        Map<String, Object> category = new HashMap<>();
        category.put("id", 1);
        category.put("AnimalName", data.get("AnimalName")); //data.get("id_int") is for reading value from excel by passing header
        json_createItem.put("category", category);
        // Convert map to JSON string using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(json_createItem);
        workbook.close();

        System.out.println(jsonString);
        return json_createItem;
    }


}
