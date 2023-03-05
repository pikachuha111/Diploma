package tests.UITests;

import baseEntities.BaseTestUI;
import com.codeborne.selenide.Selenide;
import configuration.ReadPropertiesUI;
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

public class PositiveUITests extends BaseTestUI {
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

    @Test
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
        uploadPage.getChooseFileButton().uploadFile(new File("D:\\Programms\\Diploma\\Diploma_AQA_18_onl\\src\\test\\resources\\witcher.jpg"));
        $(By.id("uploadedFilePath"))
                .shouldBe(visible)
                .shouldHave(text("C:\\fakepath\\witcher.jpg"));
    }

    @Test
    public void registerNewUserTest() throws InterruptedException {
        UserUI newUser = UserUI.builder()
                .firstName(ReadPropertiesUI.firstName())
                .lastName(ReadPropertiesUI.lastName())
                .userName(ReadPropertiesUI.userName())
                .password(ReadPropertiesUI.password())
                .build();

        userSteps.registerNewUser(newUser);
        //капчу прохожу вручную

        String alertText = Selenide.switchTo().alert().getText();
        Assert.assertEquals(alertText, "User Register Successfully.");
        Selenide.switchTo().alert().accept();
    }

    @Test
    public void deleteUserTest() throws InterruptedException {
        UserUI newUser = UserUI.builder()
                .firstName(ReadPropertiesUI.firstName())
                .lastName(ReadPropertiesUI.lastName())
                .userName(ReadPropertiesUI.userName())
                .password(ReadPropertiesUI.password())
                .build();

        userSteps.registerNewUser(newUser);
        //капчу прохожу вручную
        Selenide.switchTo().alert().accept();

        userSteps.loginUser(newUser);
        userSteps.deleteUser();

        String alertText = Selenide.switchTo().alert().getText();
        Assert.assertEquals(alertText, "User Deleted.");
        Selenide.switchTo().alert().accept();
    }
}