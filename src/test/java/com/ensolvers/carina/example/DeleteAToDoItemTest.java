package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.ensolvers.carina.example.gui.pages.common.TodoItemsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAToDoItemTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "Delete a to do Item")
    public void deleteAToDoItemTest(){
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
        todoItemsPage.clickDeleteButton();
        Assert.assertTrue(todoItemsPage.checkConfirmDeleteOperationModalAppear(),"Confirm delete operation modal is not displayed");
        todoItemsPage.clickConfirmDeleteButton();
        Assert.assertTrue(todoItemsPage.checkDeletedMessageAppear(),"Delete message is not displayed");
    }
}
