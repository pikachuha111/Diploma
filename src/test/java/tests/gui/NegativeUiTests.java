package tests.gui;

import baseEntities.BaseUiTest;
import configuration.ReadProperties;
import models.UserUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.PracticeFormPage;
import steps.PracticeFormSteps;
import steps.UserSteps;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NegativeUiTests extends BaseUiTest {

    UserSteps userSteps = new UserSteps();
    UserUI userUI = new UserUI();

    @Test
    public void incorrectLoginTest() {
        userUI.setUserName(ReadProperties.userName() + "f");
        userUI.setPassword(ReadProperties.password());

        userSteps.loginUser(userUI);
        $(By.id("name"))
                .shouldBe(visible)
                .shouldHave(text("Invalid username or password!"));
    }

    @Test
    public void maxPlusOneLengthUserNumberTest() {
        PracticeFormSteps practiceFormSteps = new PracticeFormSteps();
        PracticeFormPage practiceFormPage = new PracticeFormPage();

        String userNumber = "1234567890";

        practiceFormSteps.fillTheUserNumber(userNumber + "1");
        practiceFormPage.getUserNumberInput()
                .shouldHave(value(userNumber));
    }

    @Test(enabled = false)
    public void defectTest() {
        userUI.setUserName(ReadProperties.userName() + "f");
        userUI.setPassword(ReadProperties.password());

        userSteps.loginUser(userUI);
        $(By.id("name"))
                .shouldBe(visible)
                .shouldHave(text("Invalid username or password!" + "f"));
    }
}