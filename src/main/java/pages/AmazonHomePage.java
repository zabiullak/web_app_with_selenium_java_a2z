package pages;

import driver.DriverManager;
import enums.ConfigJson;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.JsonUtils;

public final class AmazonHomePage {

    @FindBy(id="nav-hamburger-menu")
    private WebElement linkHamburger;

    /**
     * Constructor to initialise the page factory elements. It is not recommended to use page factory
     * This is an sample for demonstration purpose
     */
    public AmazonHomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public AmazonHamburgerMenuPage clickHamburger() {
        linkHamburger.click();
        return new AmazonHamburgerMenuPage();
    }

    public AmazonHomePage navigateToUrl() {
        DriverManager.getDriver().get(JsonUtils.get(ConfigJson.AMAZONTESTURL));
        return this;
    }
}
