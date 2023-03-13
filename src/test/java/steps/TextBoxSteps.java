package steps;

import io.qameta.allure.Step;
import pages.TextBoxPage;

public class TextBoxSteps {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Step("Fill the email field")
    public void fillTheEmail(String string) {
        textBoxPage.goToTextBoxPage();
        textBoxPage.getEmailInput().val(string);
        textBoxPage.getSubmitButton().scrollTo().click();
    }
}
