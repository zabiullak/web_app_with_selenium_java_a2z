package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static enums.LogType.PASS;
import static reports.FrameworkLogger.log;

public class BasePage {

    protected void click(By by, WaitStrategy waitstrategy, String elementname) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.click();
        log(PASS,elementname+" is clicked");

    }

    protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
        WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.sendKeys(value);
        log(PASS,value +" is entered successfully in "+elementname);
    }


    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

}
