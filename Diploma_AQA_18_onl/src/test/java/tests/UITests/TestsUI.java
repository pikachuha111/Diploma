package tests.UITests;

import baseEntities.BaseTestUI;
import com.codeborne.selenide.Selenide;
import configuration.ReadPropertiesUI;
import models.UserUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.ModalDialogPage;
import steps.UserSteps;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class TestsUI extends BaseTestUI {
    CheckBoxPage checkBoxPage = new CheckBoxPage();
    UserUI newUser = new UserUI();
    UserSteps userSteps = new UserSteps();
    ModalDialogPage modalDialogPage = new ModalDialogPage();

    @Test
    public void popupMessageTest() {
        checkBoxPage.goToCheckBoxPage();
        checkBoxPage.getExpandAllButton()
                .shouldHave(attribute("aria-label", "Expand all"));
    }

    @Test
    public void modalDialogTest() {
        modalDialogPage.goToModalDialogPage();
        modalDialogPage.getSmallModalButton().click();
        String modalText = $(By.xpath("//div[text()='This is a small modal. It has very less content']")).getText();
        Assert.assertEquals(modalText, "This is a small modal. It has very less content");
        modalDialogPage.getCloseModalButton().click();
    }

    @Test //Тест не проходит из-за капчи
    public void registerNewUserTest() {
        newUser.setFirstName(ReadPropertiesUI.firstName());
        newUser.setLastName(ReadPropertiesUI.lastName());
        newUser.setUserName(ReadPropertiesUI.userName());
        newUser.setPassword(ReadPropertiesUI.password());

        userSteps.registerNewUser(newUser);

        String alertText = Selenide.switchTo().alert().getText();
        Assert.assertEquals(alertText, "User Register Successfully.");
        Selenide.switchTo().alert().accept();
    }

    //т.к. из-за капчи я не могу создать пользователя в тестовом режиме,
    @Test        // я создаю его вручную, а потом запускаю тест
    public void deleteUserTest() {
        newUser.setFirstName(ReadPropertiesUI.firstName());
        newUser.setLastName(ReadPropertiesUI.lastName());
        newUser.setUserName(ReadPropertiesUI.userName());
        newUser.setPassword(ReadPropertiesUI.password());

//        userSteps.registerNewUser(newUser);
//        Selenide.switchTo().alert().accept();

        userSteps.loginUser(newUser);
        userSteps.deleteUser();

        String alertText = Selenide.switchTo().alert().getText();
        Assert.assertEquals(alertText, "User Deleted.");
        Selenide.switchTo().alert().accept();
    }
}