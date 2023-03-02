package tests.UITests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.ElementsPage;

import static com.codeborne.selenide.Condition.attribute;

public class TestsUI extends BaseTest{
    CheckBoxPage checkBoxPage = new CheckBoxPage();
    ElementsPage elementsPage = new ElementsPage();

    @Test
    public void popupMessageTest() {
        elementsPage.goToCheckBoxPage();
        checkBoxPage.getExpandAllButton()
                .shouldHave(attribute("aria-label", "Expand all"));
            }
}