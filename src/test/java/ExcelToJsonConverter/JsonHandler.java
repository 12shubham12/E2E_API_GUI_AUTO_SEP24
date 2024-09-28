package ExcelToJsonConverter;

import org.json.JSONObject;

import java.util.Map;

public class JsonHandler {
    // Method to update JSON with Excel data
    public static String updateJsonWithExcelData(String jsonInput, Map<String, String> excelData) {
        JSONObject jsonObject = new JSONObject(jsonInput);
        // Updating "id" and "name" fields from Excel
        if (excelData.containsKey("id")) {
            jsonObject.put("id", "10");
        }
        if (excelData.containsKey("categoryName")) {
            jsonObject.getJSONObject("category").put("name", excelData.get("categoryName"));
        }

        return jsonObject.toString();
    }
}