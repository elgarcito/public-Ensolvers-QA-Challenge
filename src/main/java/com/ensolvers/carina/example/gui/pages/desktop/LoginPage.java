package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//h5[@class='modal-title']")
    private ExtendedWebElement singInTittle;

    @FindBy(id = "username")
    private ExtendedWebElement usernameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement singInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(singInTittle);
    }

    @Override
    public void typeUsername(String username) {
        usernameInput.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordInput.type(password);
    }

    @Override
    public HomePageBase clickSingInButton() {
        singInButton.click();
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public boolean checkCorrectSingIn() {
        return false;
    }

}
