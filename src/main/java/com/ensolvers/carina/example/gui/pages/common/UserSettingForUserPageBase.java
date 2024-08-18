package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class UserSettingForUserPageBase extends AbstractPage {

    public UserSettingForUserPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFirstName(String firstName);
    public abstract void typeLastName(String lastName);
    public abstract void typeEmail(String email);
    public abstract void clickSaveButton();
    public abstract boolean checkSettingSaveMessage();
}
