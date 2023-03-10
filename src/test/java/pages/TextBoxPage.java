package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TextBoxPage {

    private String TextBoxPageUrl = ReadProperties.getUrl() + "text-box";
    private SelenideElement emailInput = $(By.id("userEmail"));
    private SelenideElement emailText = $(By.id("email"));
    private SelenideElement submitButton = $(By.id("submit"));



    public void goToTextBoxPage() {
        Selenide.open(TextBoxPageUrl);
    }

}