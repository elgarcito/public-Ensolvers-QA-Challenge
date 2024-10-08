package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TodoItemsPageBase extends AbstractPage {

    public TodoItemsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CreateOrEditAToDoItemPageBase clickCreateNewToDoItemButton();
    public abstract CreateOrEditAToDoItemOnlyEditPageBase clickEditButton();
    public abstract ViewPageBase clickViewButton();
    public abstract void clickDeleteButton();
    public abstract void clickConfirmDeleteButton();
    public abstract boolean checkCreatedMessageAppear();
    public abstract boolean checkUpdatedMessageAppear();
    public abstract boolean checkConfirmDeleteOperationModalAppear();
    public abstract boolean checkDeletedMessageAppear();
}
