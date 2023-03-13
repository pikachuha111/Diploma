package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class UploadPage {

    private String uploadPageUrl = ReadProperties.getUrl() + "upload-download";
    private SelenideElement chooseFileButton = $(By.id("uploadFile"));

    public void goToUploadPage() {
        Selenide.open(uploadPageUrl);
    }
}
