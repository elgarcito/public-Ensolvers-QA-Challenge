package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }
    public abstract void clickAccountButton();
    public abstract void clickSingOutButton();
    public abstract void clickManageListsButton();
    public abstract TodoItemsPageBase clickManageToDoItemsDirectButton();
    public abstract FolderPageBase clickManageFoldersDirectButton();
    public abstract TodoItemsPageBase clickToDoItemButton();
    public abstract FolderPageBase clickFolderButton();
    public abstract UserSettingForUserPageBase clickSettingButton();
    public abstract boolean checkCorrectLogOut();
}
