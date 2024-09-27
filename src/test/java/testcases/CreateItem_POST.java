package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateItem_POST {

    @Test
    public static void createItemPOST(){

        Response response = RestAssured.given()
                //.header("")
                .contentType(ContentType.JSON)
                .baseUri("https://petstore3.swagger.io/api/v3")
                .body("{\n" +
                        "  \"id\": 10,\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Dogs\"\n" +
                        "  },\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .response();

        //return response;

        System.out.println(response.jsonPath().prettyPrint());
    }
}
