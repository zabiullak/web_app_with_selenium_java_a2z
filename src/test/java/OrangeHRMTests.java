import annotations.FrameworkAnnotation;
import constants.FrameworkConstants;
import enums.CategoryType;
import groovyjarjarantlr4.v4.runtime.Dependents;
import org.assertj.core.api.Assertions;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import utils.DataProvidersUtils;
import utils.ExcelUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public final class OrangeHRMTests extends BaseTest{

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
