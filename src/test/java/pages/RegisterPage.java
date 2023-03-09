package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class RegisterPage {
    private String registerPageUrl = ReadProperties.getUrl() + "register";
    private SelenideElement firstNameInput = $(By.id("firstname"));
    private SelenideElement lastNameInput = $(By.id("lastname"));
    private SelenideElement userNameInput = $(By.id("userName"));
    private SelenideElement passwordInput = $(By.id("password"));
    private SelenideElement captchaCheckbox = $(".recaptcha-checkbox-border");
    private SelenideElement registerButton = $(By.id("register"));

    public void goToRegisterPage() {
        Selenide.open(registerPageUrl);
    }
}
