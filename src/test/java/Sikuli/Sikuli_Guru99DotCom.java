package Sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


/*
 * Create by - Mohamad Zabiulla on 15-3-2022
 *
 * Status --> Not working (Selenium not finding Loc on the UI Page)
 *
 * */
 public final  class Sikuli_Guru99DotCom{

    public static void main(String[] args) throws FindFailed {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/executables/chromedriver.exe");
        String filepath = "src/main/resources/sikuliImages/";
        //String inputFilePath = "D:\\Guru99Demo\\Files\\";
        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath + "EnterFileName.png");
        Pattern openButton = new Pattern(filepath + "ClickOnEnter.png");
        WebDriver driver;

        // Open Chrome browser
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/image_upload/index.php");

        // Click on Browse button and handle windows pop up using Sikuli
        driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, filepath + "Questions.txt");
        s.click(openButton);

        // Close the browser
        driver.close();

    }
}
