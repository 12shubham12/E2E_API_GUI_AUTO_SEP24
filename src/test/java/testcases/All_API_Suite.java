package testcases;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseClass;
import utility.EndPointURLs;

import java.io.IOException;

public class All_API_Suite extends BaseClass{

    @Test
    public void test_createItem() throws Exception {
        Response response = CreateItem_POST.createItemPOST(EndPointURLs.base_URL_ST, config.API_ExcelDataPath(),
                config.createItemJsonPath(), "CreateItem", 1);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
