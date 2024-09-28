package utility;

import ExcelToJsonConverter.JsonHandler;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseClass {

    public static ConfigDataProvider config;
    public static ExcelDataReader excel;
    public static JsonHandler jsonHandler;

    @BeforeClass
    public void setup() throws IOException {
        config = new ConfigDataProvider();
        excel = new ExcelDataReader();
        jsonHandler = new JsonHandler();
    }

}
