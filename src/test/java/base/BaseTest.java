package base;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.Log;

import java.util.Map;

public class BaseTest {

    protected BaseTest() {}


    @BeforeMethod
    protected void setUp(Object[] data){
        Map<String, String> map =(Map<String,String >) data[0];
        Log.info("Tests are Started ***>");
        Driver.initDriver(map.get("browser"),map.get("version"));
    }

    @AfterMethod
    protected void tearDown(){
        Log.info("Tests are Ended !!!<");
        Driver.quitDriver();
    }
}
