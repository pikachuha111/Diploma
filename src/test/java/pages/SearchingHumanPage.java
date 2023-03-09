package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SearchingHumanPage {
    private String searchingHumanPageUrl = "https://namebook.club/peoples";
    private SelenideElement firstNameInput = $(By.id("first_name"));
    private SelenideElement lastNameInput = $(By.id("last_name"));
    private SelenideElement countryInput = $(By.id("country"));
    private SelenideElement birthYearInput = $(By.id("birth_year"));
    private SelenideElement searchButton = $(".search__button");

    public void goToSearchingHumanPage() {
        Selenide.open(searchingHumanPageUrl);
    }

}