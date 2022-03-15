package pages;

import driver.DriverManager;
import enums.ConfigJson;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utils.JsonUtils;

public final class SikuliPage extends BasePage{

    private static final Pattern chooseFile =   new Pattern(SikuliPage.class.getResource("ChooseFile.png"));
    private static final Pattern enterName  =   new Pattern(SikuliPage.class.getResource("EnterFileName.png"));
    private static final Pattern hitEnter   =   new Pattern(SikuliPage.class.getResource("ClickOnEnter.png"));


    //private final By ChooseFile = By.xpath(".//*[@id='photoimg']");

    String fileName = System.getProperty("user.dir")+"/src/main/java/sikuliImages/Questions.txt";

    Screen screen = new Screen();

    public SikuliPage navigateToURL() {
        DriverManager.getDriver().get(JsonUtils.get(ConfigJson.GURU99FILEUPLOAD));
        return this;
    }

    public SikuliPage clickOnChooseFileButton() {
       // click(ChooseFile, WaitStrategy.CLICKABLE,"FileUploadButton");
        //Pattern fileUpload = new Pattern(System.getProperty("user.dir")+"/src/main/java/sikuliImages/ChooseFile.png");
        try {
            screen.wait(chooseFile.similar((float) 0.90), 10).click();
            //screen.click(chooseFile);
        }
        catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
        return this;
    }

    public SikuliPage EnterFileNameIntoTextBox() {

        //Pattern fileInputText = new Pattern(System.getProperty("user.dir")+"/src/main/java/sikuliImages/EnterFileName.png");

        try {
            screen.wait(enterName.similar((float) 0.90),10).type(fileName);
            //creen.type(enterName,fileName);
        }
        catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
        return this;
    }

    public boolean ClickOnEnter() {
        //Pattern enterBox  = new Pattern(System.getProperty("user.dir")+"/src/main/java/sikuliImages/ClickOnEnter.png");
        try {
            screen.click(hitEnter.similar((float) 0.90),5);
            return true;
        }
        catch (FindFailed findFailed) {
            findFailed.printStackTrace();
            return false;
        }
    }
}
