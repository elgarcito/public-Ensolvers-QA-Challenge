package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ViewFolderPageBase extends AbstractPage {

    public ViewFolderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkId();
    public abstract boolean checkName();
    public abstract boolean checkUser();
    public abstract void clickBackButton();
}
