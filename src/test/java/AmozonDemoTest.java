import annotations.FrameworkAnnotation;
import base.BaseTest;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

import java.util.Map;

public final class AmozonDemoTest extends BaseTest {

    private AmozonDemoTest(){}

    @Test
    @FrameworkAnnotation(author = {"MKZ","Zabi"},category = {CategoryType.SMOKE})
    public void amazonTest(Map<String,String> data){
        String title =new AmazonHomePage()
                .navigateToUrl()
                .clickHamburger()
                .clickComputer()
                .clickOnSubMenuItem(data.get("menutext")).getTitle();
        Assertions.assertThat(title).isNotNull();
    }
}
