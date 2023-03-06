package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckBoxPage {
    private String checkBoxPageUrl = "https://demoqa.com/checkbox";

    private SelenideElement expandAllButton = $(".rct-option-expand-all");

    public void goToCheckBoxPage() {
        Selenide.open(checkBoxPageUrl);
    }

}