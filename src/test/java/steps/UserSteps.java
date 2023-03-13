package steps;

import io.qameta.allure.Step;
import models.UserUI;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterPage;

public class UserSteps {
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Step("registration of new user")
    public void registerNewUser(UserUI userUI) throws InterruptedException {
        registerPage.goToRegisterPage();
        Thread.sleep(3000);
        registerPage.getFirstNameInput().val(userUI.getFirstName());
        registerPage.getLastNameInput().val(userUI.getLastName());
        registerPage.getUserNameInput().val(userUI.getUserName());
        registerPage.getPasswordInput().val(userUI.getPassword());
        Thread.sleep(10000);
        registerPage.getRegisterButton().scrollTo().click();
    }

    @Step("user log in")
    public void loginUser(UserUI userUI) {
        loginPage.goToLoginPage();
        loginPage.getLoginInput().val(userUI.getUserName());
        loginPage.getPasswordInput().val(userUI.getPassword());
        loginPage.getLoginButton().scrollTo().click();
    }

    @Step("delete user")
    public void deleteUser() {
        profilePage.getDeleteButton().scrollTo().click();
        profilePage.getModalWindowOKButton().click();
    }
}