package tests.UITests;

import baseEntities.BaseTestUI;
import com.codeborne.selenide.Condition;
import configuration.ReadPropertiesUI;
import models.UserUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.UserSteps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NegativeUITests extends BaseTestUI {

    LoginPage loginPage = new LoginPage();
    UserSteps userSteps = new UserSteps();
    UserUI userUI = new UserUI();

    @Test
    public void incorrectLoginTest() {
        userUI.setUserName(ReadPropertiesUI.userName() + "f");
        userUI.setPassword(ReadPropertiesUI.password());

        loginPage.goToLoginPage();
        userSteps.loginUser(userUI);
        $(By.id("name"))
                .shouldBe(visible);
    }
}
