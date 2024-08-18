package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAFolderPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = CreateOrEditAFolderPageBase.class)
public class CreateOrEditAFolder extends CreateOrEditAFolderPageBase {

    @FindBy(id = "ensolversQaChallengeApp.folder.home.createOrEditLabel")
    private ExtendedWebElement createOrEditAFolderTitle;

    @FindBy(id = "folder-name")
    private ExtendedWebElement inputFolderName;

    @FindBy(id = "save-entity")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'error.http.500')]")
    private ExtendedWebElement longNameErrorMessage;

    public CreateOrEditAFolder(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(createOrEditAFolderTitle);
    }

    @Override
    public void typeFolderName(String folderName) {
        inputFolderName.type(folderName);
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    public boolean checkErrorCreatedMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(longNameErrorMessage));
        return longNameErrorMessage.isDisplayed();
    }
}
