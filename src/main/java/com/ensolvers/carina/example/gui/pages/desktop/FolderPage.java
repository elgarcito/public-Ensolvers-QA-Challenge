package com.ensolvers.carina.example.gui.pages.desktop;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAFolderOnlyEditPageBase;
import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAFolderPageBase;
import com.ensolvers.carina.example.gui.pages.common.FolderPageBase;
import com.ensolvers.carina.example.gui.pages.common.ViewFolderPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = FolderPageBase.class)
public class FolderPage extends FolderPageBase {

    @FindBy(id="folder-heading")
    private ExtendedWebElement folderPageTitle;

    @FindBy(xpath = "//a[@class='btn btn-primary jh-create-entity' and @data-cy='entityCreateButton']")
    private ExtendedWebElement createNewFolder;

    @FindBy(xpath = "//div[contains(text(),'A new folder is created with identifier ')]")
    private ExtendedWebElement createdFolderMessage;

    @FindBy(xpath = "//div[contains(text(),'A folder is updated with identifier')]")
    private ExtendedWebElement updatedFolderMessage;

    @FindBy(xpath = "//span[contains(text(),\"Edit\")][1]")
    private ExtendedWebElement editButton;

    @FindBy(xpath = "//span[contains(text(),\"View\")][1]")
    private ExtendedWebElement viewButton;

    @FindBy(xpath = "//span[contains(text(),\"Delete\")][1]")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//div[@class='modal-content']//div[@data-cy='folderDeleteDialogHeading']")
    private ExtendedWebElement confirmDeleteModal;

    @FindBy(id = "jhi-confirm-delete-folder")
    private ExtendedWebElement confirmDeleteButton;

    @FindBy(xpath = "//div[contains(text(),'A folder is deleted with identifier ')]")
    private ExtendedWebElement deletedFolderMessage;


    public FolderPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(folderPageTitle);
    }

    @Override
    public CreateOrEditAFolderPageBase clickCreateNewFolderButton() {
        createNewFolder.click();
        return initPage(getDriver(), CreateOrEditAFolderPageBase.class);
    }

    @Override
    public boolean checkCreatedMessageAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(createdFolderMessage));
        return createdFolderMessage.isDisplayed();
    }

    @Override
    public CreateOrEditAFolderOnlyEditPageBase clickEditFolderButton() {
        editButton.click();
        return initPage(getDriver(), CreateOrEditAFolderOnlyEditPageBase.class);
    }

    @Override
    public boolean checkUpdatedMessageAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(updatedFolderMessage));
        return updatedFolderMessage.isDisplayed();
    }

    @Override
    public ViewFolderPageBase clickViewFolderButton() {
        viewButton.click();
        return initPage(getDriver(), ViewFolderPageBase.class);
    }


    @Override
    public void clickDeleteFolderButton() {
        deleteButton.click();
    }

    @Override
    public void clickConfirmDeleteFolderButton() {
        confirmDeleteButton.click();
    }

    @Override
    public boolean checkConfirmDeleteOperationModalAppear() {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteModal));
        return confirmDeleteModal.isDisplayed();
    }

    @Override
    public boolean checkDeletedMessageAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(deletedFolderMessage));
        return deletedFolderMessage.isDisplayed();
    }
}
