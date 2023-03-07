package tests.gui;

import baseEntities.BaseUiTest;
import configuration.ReadPropertiesUI;
import models.HumanUI;
import models.UserUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.HumanSteps;
import steps.UserSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NegativeTestsUi extends BaseUiTest {

    UserSteps userSteps = new UserSteps();
    UserUI userUI = new UserUI();
    HumanSteps humanSteps = new HumanSteps();

    @Test
    public void incorrectLoginTest() {
        userUI.setUserName(ReadPropertiesUI.userName() + "f");
        userUI.setPassword(ReadPropertiesUI.password());

        userSteps.loginUser(userUI);
        $(By.id("name"))
                .shouldBe(visible)
                .shouldHave(text("Invalid username or password!"));
    }

    @Test
    public void minValueTestPlusOne() {
        HumanUI humanUI = HumanUI.builder()
                .firstName("Василий")
                .lastName("Васильев")
                .country("Беларусь")
                .birthYear("10000")
                .build();

        humanSteps.startSearching(humanUI);
        $(By.id("error"))
                .shouldBe(visible)
                .shouldHave(text("Нужно указать год рождения состоящий из четырех цифр."));
    }

    @Test
    public void defectTest() {
        userUI.setUserName(ReadPropertiesUI.userName() + "f");
        userUI.setPassword(ReadPropertiesUI.password());

        userSteps.loginUser(userUI);
        $(By.id("name"))
                .shouldBe(visible)
                .shouldHave(text("Invalid username or password!" + "f"));
    }
}