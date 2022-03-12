import constants.FrameworkConstants;
import org.assertj.core.api.Assertions;
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

    @Test(dataProvider = "getTestData", dataProviderClass = DataProvidersUtils.class)
    public void loginLogoutTest(Map<String,String> data) {
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

}
