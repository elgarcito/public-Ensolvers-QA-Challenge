package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ViewPageBase extends AbstractPage {

    public ViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkId();
    public abstract boolean checkTitle();
    public abstract boolean checkDescription();
    public abstract boolean checkUser();
    public abstract boolean checkFolder();
    public abstract void clickBackButton();
    public abstract CreateOrEditAToDoItemOnlyEditPageBase clickEditButton();

}
