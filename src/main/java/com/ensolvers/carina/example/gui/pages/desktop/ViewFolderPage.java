package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.ViewFolderPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = ViewFolderPageBase.class)
public class ViewFolderPage extends ViewFolderPageBase {
    @FindBy(xpath = "//h2[@data-cy='folderDetailsHeading']")
    private ExtendedWebElement detailedViewTitle;

    @FindBy(id = "id")
    private ExtendedWebElement idView;

    @FindBy(id = "name")
    private ExtendedWebElement nameView;

    @FindBy(xpath = "//dt[contains(text(),'User')]")
    private ExtendedWebElement userView;

    @FindBy(xpath = "//a//span[contains(text(),'Back')]")
    private ExtendedWebElement backButton;

    public ViewFolderPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(detailedViewTitle);
    }

    @Override
    public boolean checkId() {
        return idView.isDisplayed();
    }

    @Override
    public boolean checkName() {
        return nameView.isDisplayed();
    }

    @Override
    public boolean checkUser() {
        return userView.isDisplayed();
    }

    @Override
    public void clickBackButton() {
        backButton.click();
    }
}
