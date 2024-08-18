package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditToDoItemTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "edit a to do Item")
    public void editAToDoItem(){
        LoginPageBase loginPage=initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Home page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("correctUser"));
        loginPage.typePassword(R.TESTDATA.get("correctPassword"));
        HomePageBase homePage = loginPage.clickSingInButton();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
        homePage.clickManageListsButton();
        TodoItemsPageBase todoItemsPage=homePage.clickToDoItemButton();
        Assert.assertTrue(todoItemsPage.isPageOpened(),"To do items page is not opened");
        CreateOrEditAToDoItemOnlyEditPageBase createOrEditAToDoItemPage= todoItemsPage.clickEditButton();
        Assert.assertTrue(createOrEditAToDoItemPage.isPageOpened(),"Create Or Edit A ToDoItem page is not opened");
        createOrEditAToDoItemPage.typeTitle(R.TESTDATA.get("newTitle"));
        createOrEditAToDoItemPage.typeDescription(R.TESTDATA.get("newDescription"));
        createOrEditAToDoItemPage.selectFolder();
        createOrEditAToDoItemPage.clickSaveButton();
        Assert.assertTrue(todoItemsPage.isPageOpened(),"To do items page is not opened");
        Assert.assertTrue(todoItemsPage.checkUpdatedMessageAppear(),"updated message did not appear");
    }
}
