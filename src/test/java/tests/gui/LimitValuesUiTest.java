package tests.gui;

import baseEntities.BaseUiTest;
import models.HumanUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.HumanSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class LimitValuesUiTest extends BaseUiTest {

    HumanSteps humanSteps = new HumanSteps();

    @Test
    public void minValueTest() {
        HumanUI humanUI = HumanUI.builder()
                .firstName("Василий")
                .lastName("Васильев")
                .country("Беларусь")
                .birthYear("1000")
                .build();

        humanSteps.startSearching(humanUI);
        $(By.xpath("//span[text()='Результат поиска по базе данных людей']"))
                .shouldBe(visible)
                .shouldHave(text("Результат поиска по базе данных людей"));
    }

    @Test
    public void maxValueTest() {
        HumanUI humanUI = HumanUI.builder()
                .firstName("Василий")
                .lastName("Васильев")
                .country("Беларусь")
                .birthYear("9999")
                .build();

        humanSteps.startSearching(humanUI);
        $(By.xpath("//span[text()='Результат поиска по базе данных людей']"))
                .shouldBe(visible)
                .shouldHave(text("Результат поиска по базе данных людей"));
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
    public void minValueTestMinusOne() {
        HumanUI humanUI = HumanUI.builder()
                .firstName("Василий")
                .lastName("Васильев")
                .country("Беларусь")
                .birthYear("999")
                .build();

        humanSteps.startSearching(humanUI);
        $(By.id("error"))
                .shouldBe(visible)
                .shouldHave(text("Нужно указать год рождения состоящий из четырех цифр."));
    }
}