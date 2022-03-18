package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import utils.Log;

public final class OrangeHRMHomePage extends BasePage{

    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[text()='Logout']");


    public OrangeHRMHomePage clickWelcome() {
        click(linkWelcome, WaitStrategy.PRESENCE,"Welcome link");
        Log.info("clicked on Welcome Page");
        return this;
    }



    public OrangeHRMLoginPage clickLogout() {
        click(linkLogout, WaitStrategy.CLICKABLE,"Logout button");
        Log.info("logout from the Oranage HRM Page");
        return new OrangeHRMLoginPage();
    }

}
