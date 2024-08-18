package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FolderPageBase extends AbstractPage {

    public FolderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CreateOrEditAFolderPageBase clickCreateNewFolderButton();
    public abstract CreateOrEditAFolderPageBase clickEditFolderButton();
    public abstract ViewFolderPageBase clickViewFolderButton();
    public abstract void clickDeleteFolderButton();
    public abstract void clickConfirmDeleteFolderButton();
    public abstract boolean checkCreatedMessageAppear();
    public abstract boolean checkUpdatedMessageAppear();
    public abstract boolean checkConfirmDeleteOperationModalAppear();
    public abstract boolean checkDeletedMessageAppear();

}
