package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CreateOrEditAToDoItemOnlyEditPageBase extends AbstractPage {
    public CreateOrEditAToDoItemOnlyEditPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeTitle(String tittle);
    public abstract void typeDescription(String description);
    public abstract void selectFolder();
    public abstract void clickSaveButton();
}
