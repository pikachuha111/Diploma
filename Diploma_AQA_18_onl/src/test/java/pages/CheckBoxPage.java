package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckBoxPage {
    private String pagePath = "https://demoqa.com/checkbox";

    public SelenideElement expandAll = $(".rct-icon-expand-all");

    public void open() {
        expandAll.click();
    }


}
