import annotations.FrameworkAnnotation;
import base.BaseTest;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests(){}

    @Test
    @FrameworkAnnotation(author = "zabiulla", category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
    public void loginLogoutTest(Map<String,String> data) {
        String title = new OrangeHRMLoginPage()
                .navigateToURL()
                .enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    @FrameworkAnnotation(author = "zabiulla", category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
    public void newTest(Map<String,String> data) {

        String title = new OrangeHRMLoginPage()
                .navigateToURL()
                .enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();
        throw new SkipException("skip");
    }

}
