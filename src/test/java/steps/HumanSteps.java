package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.HumanUI;
import pages.SearchingHumanPage;

import java.time.Duration;

public class HumanSteps {
    SearchingHumanPage searchingHumanPage = new SearchingHumanPage();

    public void startSearching(HumanUI humanUI) {
        searchingHumanPage.goToSearchingHumanPage();
        searchingHumanPage.getFirstNameInput().val(humanUI.getFirstName());
        searchingHumanPage.getLastNameInput().val(humanUI.getLastName());
        searchingHumanPage.getCountryInput().val(humanUI.getCountry());
        searchingHumanPage.getBirthYearInput().val(humanUI.getBirthYear());
        searchingHumanPage.getSearchButton().click();
    }
}