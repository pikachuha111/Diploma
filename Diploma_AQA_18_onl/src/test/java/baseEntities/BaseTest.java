package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 20000;
    }

    @BeforeMethod
    public void start() {
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}