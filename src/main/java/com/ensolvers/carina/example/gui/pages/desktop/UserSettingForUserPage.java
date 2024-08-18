package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.UserSettingForUserPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = UserSettingForUserPageBase.class)
public class UserSettingForUserPage extends UserSettingForUserPageBase {

    @FindBy(id = "settings-title")
    private ExtendedWebElement settingTitle;

    @FindBy(id = "firstName")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "lastName")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'Settings saved!')]")
    private ExtendedWebElement savedModificationsMessage;


    public UserSettingForUserPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(settingTitle);
    }

    @Override
    public void typeFirstName(String firstName) {
        firstNameInput.type(firstName);
    }

    @Override
    public void typeLastName(String lastName) {
        lastNameInput.type(lastName);
    }

    @Override
    public void typeEmail(String email) {
        emailInput.type(email);
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    public boolean checkSettingSaveMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(savedModificationsMessage));
        return savedModificationsMessage.isDisplayed();
    }


}
