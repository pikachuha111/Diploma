package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProfilePage {
    private String profilePageUrl = ReadProperties.getUrl() + "profile";
    private SelenideElement deleteButton = $(By.xpath("//button[text()='Delete Account']"));
    private SelenideElement modalWindowOKButton = $(By.id("closeSmallModal-ok"));

}
