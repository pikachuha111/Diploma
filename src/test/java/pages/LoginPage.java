package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage {

    private String loginPageUrl = "https://demoqa.com/login";
    private SelenideElement loginInput = $(By.id("userName"));
    private SelenideElement passwordInput = $(By.id("password"));
    private SelenideElement loginButton = $(By.id("login"));

    public void goToLoginPage() {
        Selenide.open(loginPageUrl);
    }

}
