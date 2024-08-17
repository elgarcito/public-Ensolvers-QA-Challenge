package com.ensolvers.carina.example.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUsername(String username);
    public abstract void typePassword(String password);
    public abstract HomePageBase clickSingInButton();
    public abstract boolean checkInCorrectSingIn();
}
