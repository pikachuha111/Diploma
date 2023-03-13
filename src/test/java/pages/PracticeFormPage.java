package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class PracticeFormPage {

    private String practiceFormPageUrl = ReadProperties.getUrl() + "automation-practice-form";
    private SelenideElement userNumberInput = $(By.id("userNumber"));

    public void goToPracticeFormPage() {
        Selenide.open(practiceFormPageUrl);
    }
}