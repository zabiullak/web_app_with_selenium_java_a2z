package trial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Sample1 {

    WebDriver driver;



    @Test
    public void m1(){
        driver.get("http://amazon.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }
}
