package steps;

import pages.TextBoxPage;

public class TextBoxSteps {

    TextBoxPage textBoxPage = new TextBoxPage();

    public void fillTheEmail(String string) {
        textBoxPage.goToTextBoxPage();
        textBoxPage.getEmailInput().val(string);
        textBoxPage.getSubmitButton().scrollTo().click();
    }
}
