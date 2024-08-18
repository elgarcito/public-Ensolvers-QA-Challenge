package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAToDoItemOnlyEditPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = CreateOrEditAToDoItemOnlyEditPageBase.class)
public class CreateOrEditAToDoItemOnlyEditPage extends CreateOrEditAToDoItemOnlyEditPageBase {

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

    @FindBy(xpath = "//*[@id=\"to-do-item-folder\"]")
    private ExtendedWebElement folderList;


    public CreateOrEditAToDoItemOnlyEditPage(WebDriver driver) {
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
        //Select sel = new Select(folderList);
        folderList.select(1);
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }
}
