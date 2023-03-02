package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckBoxPage {

    private SelenideElement expandAllButton = $(".rct-option-expand-all");


}