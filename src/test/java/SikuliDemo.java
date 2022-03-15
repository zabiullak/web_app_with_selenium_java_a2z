import annotations.FrameworkAnnotation;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import pages.SikuliPage;

import java.util.Map;

/*
*  Reffered --> https://www.guru99.com/sikuli-tutorial.html
*
*
* */
public final class SikuliDemo extends BaseTest{

    private SikuliDemo(){}

    @Test
    @FrameworkAnnotation(author = "zabi",category = {CategoryType.SANITY})
    public void sikuliTest(Map<String,String> data){

        boolean isUploaded  = new SikuliPage()
                .navigateToURL()
                .clickOnChooseFileButton()
                .EnterFileNameIntoTextBox()
                .ClickOnEnter();

        Assertions.assertThat(isUploaded).isTrue();

    }
}
