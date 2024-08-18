package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CreateOrEditAFolderPageBase extends AbstractPage {
    public CreateOrEditAFolderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFolderName(String folderName);
    public abstract void clickSaveButton();
}
