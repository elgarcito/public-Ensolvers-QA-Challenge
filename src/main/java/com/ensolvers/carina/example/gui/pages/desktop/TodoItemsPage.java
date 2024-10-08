package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAToDoItemOnlyEditPageBase;
import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAToDoItemPageBase;
import com.ensolvers.carina.example.gui.pages.common.TodoItemsPageBase;
import com.ensolvers.carina.example.gui.pages.common.ViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = TodoItemsPageBase.class)
public class TodoItemsPage extends TodoItemsPageBase {


    @FindBy(id = "to-do-item-heading")
    private ExtendedWebElement toDoItemsTittle;

    @FindBy(xpath = "//a[@class='btn btn-primary jh-create-entity' and @data-cy='entityCreateButton']")
    private ExtendedWebElement createNewToDoItemButton;

    @FindBy(xpath = "//div[contains(text(),'A new toDoItem is created with identifier ')]")
    private ExtendedWebElement createdNewToDoItemMessage;

    @FindBy(xpath = "//div[contains(text(),'A toDoItem is updated with identifier')]")
    private ExtendedWebElement updatedToDoItemMessage;

    //@FindBy(xpath = "//span[contains(text(),\"Edit\")][1]")
    @FindBy(xpath = "//a//span[contains(text(),\"Edit\")]")
    private ExtendedWebElement editButton;

    //@FindBy(xpath = "//span[contains(text(),\"View\")][1]")
    @FindBy(xpath = "//a//span[contains(text(),\"View\")]")
    private ExtendedWebElement viewButton;

    //@FindBy(xpath = "//span[contains(text(),\"Delete\")][1]")
    @FindBy(xpath = "//a//span[contains(text(),\"Delete\")]")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//div[@class='modal-content']//div[@data-cy='toDoItemDeleteDialogHeading']")
    private ExtendedWebElement confirmDeleteModal;

    @FindBy(id = "jhi-confirm-delete-toDoItem")
    private ExtendedWebElement confirmDeleteButton;

    @FindBy(xpath = "//div[contains(text(),'A toDoItem is deleted with identifier ')]")
    private ExtendedWebElement deletedToDoItemMessage;


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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(createdNewToDoItemMessage));
        return createdNewToDoItemMessage.isDisplayed();
    }

    @Override
    public CreateOrEditAToDoItemOnlyEditPageBase clickEditButton() {
        editButton.click();
        return initPage(getDriver(),CreateOrEditAToDoItemOnlyEditPageBase.class);
    }

    @Override
    public boolean checkUpdatedMessageAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(updatedToDoItemMessage));
        return updatedToDoItemMessage.isDisplayed();
    }

    @Override
    public ViewPageBase clickViewButton() {
        viewButton.click();
        return initPage(getDriver(), ViewPageBase.class);
    }

    @Override
    public boolean checkConfirmDeleteOperationModalAppear() {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteModal));
        return confirmDeleteModal.isDisplayed();
    }

    @Override
    public void clickDeleteButton() {
        deleteButton.click();
    }

    @Override
    public void clickConfirmDeleteButton() {
        confirmDeleteButton.click();
    }

    @Override
    public boolean checkDeletedMessageAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(deletedToDoItemMessage));
        return deletedToDoItemMessage.isDisplayed();
    }
}
