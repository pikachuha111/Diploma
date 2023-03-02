package pages;

import com.codeborne.selenide.Selenide;

public class ElementsPage {
    private String checkBoxPageUrl = "https://demoqa.com/checkbox";

    public void goToCheckBoxPage() {
        Selenide.open(checkBoxPageUrl);
    }
}
