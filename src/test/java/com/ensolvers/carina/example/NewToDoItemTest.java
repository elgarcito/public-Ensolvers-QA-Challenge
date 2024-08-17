package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAToDoItemPageBase;
import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.ensolvers.carina.example.gui.pages.common.TodoItemsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewToDoItemTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "New to do Item")
    public void newToDoItemTest(){
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
        CreateOrEditAToDoItemPageBase createOrEditAToDoItemPage= todoItemsPage.clickCreateNewToDoItemButton();
        Assert.assertTrue(createOrEditAToDoItemPage.isPageOpened(),"Create Or Edit A ToDoItem page is not opened");
        createOrEditAToDoItemPage.typeTitle(R.TESTDATA.get("title"));
        createOrEditAToDoItemPage.typeDescription(R.TESTDATA.get("description"));
        createOrEditAToDoItemPage.selectFolder();
        createOrEditAToDoItemPage.clickSaveButton();
        Assert.assertTrue(todoItemsPage.isPageOpened(),"To do items page is not opened");
        Assert.assertTrue(todoItemsPage.checkCreatedMessageAppear(),"Created new to do message did not appear");
    }
}
