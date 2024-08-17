package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAToDoItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = CreateOrEditAToDoItemPageBase.class)
public class CreateOrEditAToDoItemPage extends CreateOrEditAToDoItemPageBase {

    @FindBy(id = "ensolversQaChallengeApp.toDoItem.home.createOrEditLabel")
    private ExtendedWebElement createOrEditAToDoItemPageTitle;

    @FindBy(id = "to-do-item-title")
    private ExtendedWebElement titleInput;

    @FindBy(id = "to-do-item-description")
    private ExtendedWebElement descriptionInput;

    @FindBy(id = "save-entity")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'error.http.500')]")
    private ExtendedWebElement longTitleErrorMessage;

    private WebElement folderList=driver.findElement(By.id("to-do-item-folder"));

    public CreateOrEditAToDoItemPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(createOrEditAToDoItemPageTitle);
    }

    @Override
    public void typeTitle(String tittle) {
        titleInput.type(tittle);
    }

    @Override
    public void typeDescription(String description) {
        descriptionInput.type(description);
    }

    @Override
    public void selectFolder() {
        //folderList.click();
        Select sel = new Select(folderList);
        sel.selectByIndex(1);
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    public boolean checkErrorCreatedMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(longTitleErrorMessage));
        return longTitleErrorMessage.isDisplayed();
    }
}
