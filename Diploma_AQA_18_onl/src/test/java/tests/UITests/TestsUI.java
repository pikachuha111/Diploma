package tests.UITests;

import baseEntities.BaseTest;
import com.codeborne.selenide.Selenide;
import configuration.ReadProperties;
import models.UserUI;
import org.testng.annotations.Test;
import pages.CheckBoxPage;


public class TestsUI extends BaseTest{
    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @Test
    public void popupMessageTest() {
        Selenide.open(checkBoxPage.getPagePath());
        checkBoxPage.open();

    }
}