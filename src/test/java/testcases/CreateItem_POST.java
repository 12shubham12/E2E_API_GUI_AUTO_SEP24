package testcases;

import ExcelToJsonConverter.JsonHandler;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import utility.BaseClass;
import utility.ExcelDataReader;

import java.nio.file.Files;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class CreateItem_POST extends BaseClass {

    public static Response createItemPOST(String endpoint, String excelFilePath, String jsonInputFilePath,
                                          String sheetName, int rowNum) throws Exception {
        // Read JSON input from the file
        String jsonInput = new String(Files.readAllBytes(Paths.get(jsonInputFilePath)));
        // Read from excel
        Map<String, String> rowData = excel.readExcelData(excelFilePath, sheetName, rowNum);
        // Update JSON with Excel data
        String updatedJson = jsonHandler.updateJsonWithExcelData(jsonInput, rowData);

        Response response = RestAssured.given()
                //.header("")
                .contentType(ContentType.JSON)
                .baseUri(endpoint)
                .body(updatedJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.jsonPath().prettyPrint());

        return response;

    }
}
