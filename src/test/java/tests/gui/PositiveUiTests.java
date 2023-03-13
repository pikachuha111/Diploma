package tests.gui;

import baseEntities.BaseUiTest;
import com.codeborne.selenide.Selenide;
import configuration.ReadProperties;
import models.UserUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.UploadPage;
import pages.ModalDialogPage;
import steps.UserSteps;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PositiveUiTests extends BaseUiTest {
    CheckBoxPage checkBoxPage = new CheckBoxPage();
    UserSteps userSteps = new UserSteps();
    ModalDialogPage modalDialogPage = new ModalDialogPage();
    UploadPage uploadPage = new UploadPage();

    @Test
    public void popupMessageTest() {
        checkBoxPage.goToCheckBoxPage();
        checkBoxPage.getExpandAllButton()
                .shouldHave(attribute("aria-label", "Expand all"));
    }

    @Test(enabled = false)
    public void modalDialogTest() {
        modalDialogPage.goToModalDialogPage();
        modalDialogPage.getSmallModalButton().click();
        String modalText = $(By.xpath("//div[text()='This is a small modal. It has very less content']")).getText();
        Assert.assertEquals(modalText, "This is a small modal. It has very less content");
        modalDialogPage.getCloseModalButton().click();
    }

    @Test
    public void uploadFileTest() {
        uploadPage.goToUploadPage();
        uploadPage.getChooseFileButton().uploadFile(new File("src/test/resources/witcher.jpg"));
        $(By.id("uploadedFilePath"))
                .shouldBe(visible)
                .shouldHave(text("C:\\fakepath\\witcher.jpg"));
    }

    @Test(enabled = false)
    public void registerNewUserTest() throws InterruptedException {
        UserUI newUser = UserUI.builder()
                .firstName(ReadProperties.firstName())
                .lastName(ReadProperties.lastName())
                .userName(ReadProperties.userName())
                .password(ReadProperties.password())
                .build();

        userSteps.registerNewUser(newUser);

        String alertText = Selenide.switchTo().alert().getText();
        Assert.assertEquals(alertText, "User Register Successfully.");
        Selenide.switchTo().alert().accept();
    }

    @Test(enabled = false)
    public void deleteUserTest() throws InterruptedException {
        UserUI newUser = UserUI.builder()
                .firstName(ReadProperties.firstName())
                .lastName(ReadProperties.lastName())
                .userName(ReadProperties.userName() + "1")
                .password(ReadProperties.password())
                .build();

        userSteps.registerNewUser(newUser);
        Selenide.switchTo().alert().accept();

        userSteps.loginUser(newUser);
        userSteps.deleteUser();

        String alertText = Selenide.switchTo().alert().getText();
        Assert.assertEquals(alertText, "User Deleted.");
        Selenide.switchTo().alert().accept();
    }
}