package steps;

import io.qameta.allure.Step;
import pages.PracticeFormPage;

public class PracticeFormSteps {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Step("Fill the user number field")
    public void fillTheUserNumber(String string) {
        practiceFormPage.goToPracticeFormPage();
        practiceFormPage.getUserNumberInput().val(string);
    }
}
