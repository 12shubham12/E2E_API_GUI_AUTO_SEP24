package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    Properties prop;
    public ConfigDataProvider(){
        File src = new File("./Config/config.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            prop=new Properties();
            prop.load(fis);
        }
        catch(Exception e){
            System.out.println("Not able to load Configfile "+e.getMessage());
        }
    }
    public String createItemJsonPath(){
        return prop.getProperty("createItem_jsonFile");
    }
    public String API_ExcelDataPath(){
        return prop.getProperty("test_data_excel_path");
    }
}
