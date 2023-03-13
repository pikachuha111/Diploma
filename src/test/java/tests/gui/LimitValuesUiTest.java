package tests.gui;

import baseEntities.BaseUiTest;
import org.testng.annotations.Test;
import pages.TextBoxPage;
import steps.TextBoxSteps;

import static com.codeborne.selenide.Condition.*;


public class LimitValuesUiTest extends BaseUiTest {

    TextBoxSteps textBoxSteps = new TextBoxSteps();
    TextBoxPage textBoxPage = new TextBoxPage();
    private String email = "example@gmail.com";

    @Test
    public void maxDomainLength() {
        textBoxSteps.fillTheEmail(email);
        textBoxPage.getEmailText()
                .shouldBe(visible)
                .shouldHave(text("Email:example@gmail.com"));
    }

    @Test
    public void minDomainLength() {
        textBoxSteps.fillTheEmail(email.substring(0, 16));
        textBoxPage.getEmailText()
                .shouldBe(visible)
                .shouldHave(text("Email:example@gmail.co"));
    }

    @Test
    public void maxMinusOneDomainLength() {
        textBoxSteps.fillTheEmail(email + "m");
        textBoxPage.getEmailText()
                .shouldNotBe(visible);
    }

    @Test
    public void minMinusOneDomainLength() {
        textBoxSteps.fillTheEmail(email.substring(0, 15));
        textBoxPage.getEmailText()
                .shouldNotBe(visible);
    }

}