package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadPropertiesUI;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import steps.HumanSteps;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseUiTest {
    protected HumanSteps humanSteps;

    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = ReadPropertiesUI.browserName();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = ReadPropertiesUI.getUrl();
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 300000;

        humanSteps = new HumanSteps();

    }

    @BeforeMethod
    public void start() {
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}