package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.FolderPageBase;
import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.TodoItemsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//h2[contains(text(),\"Welcome to Ensolvers QA Challenge!\")]")
    private ExtendedWebElement homePageTittle;

    @FindBy(id = "account-menu")
    private ExtendedWebElement accountMenuButton;

    @FindBy(xpath = "//a[@data-cy=\"logout\"]")
    private ExtendedWebElement singOutButton;

    @FindBy(xpath = "//h4[contains(text(),\"Logged out successfully!\")]")
    private ExtendedWebElement loggedOutSuccessfullyMessage;

    @FindBy(id = "entity-menu")
    private ExtendedWebElement manageListsButton;

    @FindBy(xpath = "//a[@class='dropdown-item'][text()='To Do Item']")
    private ExtendedWebElement toDoItemButton;

    @FindBy(xpath = "//a[text()='Folder']")
    private ExtendedWebElement folderButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(homePageTittle);
    }

    @Override
    public void clickAccountButton() {
        accountMenuButton.click();
    }

    @Override
    public void clickSingOutButton() {
        singOutButton.click();
    }

    @Override
    public boolean checkCorrectLogOut() {
        return loggedOutSuccessfullyMessage.isDisplayed();
    }

    @Override
    public void clickManageListsButton() {
        manageListsButton.click();
    }

    @Override
    public TodoItemsPageBase clickToDoItemButton() {
        toDoItemButton.click();
        return initPage(getDriver(),TodoItemsPageBase.class);
    }

    @Override
    public FolderPageBase clickFolderButton() {
        folderButton.click();
        return initPage(getDriver(),FolderPageBase.class);
    }
}
