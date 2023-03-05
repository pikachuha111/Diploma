package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ModalDialogPage {
    private String modalDialogPageUrl = "https://demoqa.com/modal-dialogs";

    private SelenideElement smallModalButton = $(By.id("showSmallModal"));
    private SelenideElement closeModalButton = $(By.id("closeSmallModal"));

    public void goToModalDialogPage() {
        Selenide.open(modalDialogPageUrl);
    }
}
