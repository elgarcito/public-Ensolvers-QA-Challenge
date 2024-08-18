package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAToDoItemOnlyEditPageBase;
import com.ensolvers.carina.example.gui.pages.common.ViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = ViewPageBase.class)
public class ViewPage extends ViewPageBase {
    @FindBy(xpath = "//h2[@data-cy='toDoItemDetailsHeading']")
    private ExtendedWebElement detailedViewTitle;

    @FindBy(id = "id")
    private ExtendedWebElement idView;

    @FindBy(id = "title")
    private ExtendedWebElement titleView;

    @FindBy(id = "description")
    private ExtendedWebElement descriptionView;

    @FindBy(xpath = "//dt[contains(text(),'User')]")
    private ExtendedWebElement userView;

    @FindBy(xpath = "//dt[contains(text(),'Folder')]")
    private ExtendedWebElement folderView;

    @FindBy(xpath = "//a//span[contains(text(),'Edit')]")
    private ExtendedWebElement editButton;

    @FindBy(xpath = "//a//span[contains(text(),'Back')]")
    private ExtendedWebElement backButton;

    public ViewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(detailedViewTitle);
    }

    @Override
    public boolean checkId() {
        return idView.isDisplayed();
    }

    @Override
    public boolean checkTitle() {
        return titleView.isDisplayed();
    }

    @Override
    public boolean checkDescription() {
        return descriptionView.isDisplayed();
    }

    @Override
    public boolean checkUser() {
        return userView.isDisplayed();
    }

    @Override
    public boolean checkFolder() {
        return folderView.isDisplayed();
    }

    @Override
    public void clickBackButton() {
        backButton.click();
    }

    @Override
    public CreateOrEditAToDoItemOnlyEditPageBase clickEditButton() {
        editButton.click();
        return initPage(getDriver(), CreateOrEditAToDoItemOnlyEditPageBase.class);
    }
}
