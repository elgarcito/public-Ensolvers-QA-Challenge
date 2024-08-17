package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAToDoItemPageBase;
import com.ensolvers.carina.example.gui.pages.common.TodoItemsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = TodoItemsPageBase.class)
public class TodoItemsPage extends TodoItemsPageBase {


    @FindBy(id = "to-do-item-heading")
    private ExtendedWebElement toDoItemsTittle;

    @FindBy(xpath = "//a[@class='btn btn-primary jh-create-entity' and @data-cy='entityCreateButton']")
    private ExtendedWebElement createNewToDoItemButton;

    @FindBy(xpath = "//div[contains(text(),'A new toDoItem is created with identifier ')]")
    private ExtendedWebElement createdNewToDoItemMessage;

    public TodoItemsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(toDoItemsTittle);
    }

    @Override
    public CreateOrEditAToDoItemPageBase clickCreateNewToDoItemButton() {
        createNewToDoItemButton.click();
        return initPage(getDriver(), CreateOrEditAToDoItemPageBase.class);
    }

    @Override
    public boolean checkCreatedMessageAppear() {
        return createdNewToDoItemMessage.isDisplayed();
    }
}
