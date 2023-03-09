package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseUiTest {

    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 300000;
    }

//    @BeforeMethod
//    public void start() {
//    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}