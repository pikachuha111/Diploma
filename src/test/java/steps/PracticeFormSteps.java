package steps;

import pages.PracticeFormPage;

public class PracticeFormSteps {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    public void fillTheUserNumber(String string) {
        practiceFormPage.goToPracticeFormPage();
        practiceFormPage.getUserNumberInput().val(string);
    }
}
