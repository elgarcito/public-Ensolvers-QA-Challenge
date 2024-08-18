package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.ensolvers.carina.example.gui.pages.common.TodoItemsPageBase;
import com.ensolvers.carina.example.gui.pages.common.ViewPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewToDoItemTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "view a to do Item in detail")
    public void viewToDoItemTest(){
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
        ViewPageBase viewPage=todoItemsPage.clickViewButton();
        Assert.assertTrue(viewPage.isPageOpened(),"View page is not opened");
        Assert.assertTrue(viewPage.checkId(),"ID item is not displayed");
        Assert.assertTrue(viewPage.checkTitle(),"Title item is not displayed");
        Assert.assertTrue(viewPage.checkDescription(),"Description item is not displayed");
        Assert.assertTrue(viewPage.checkUser(),"User item is not displayed");
        Assert.assertTrue(viewPage.checkFolder(),"Folder item is not displayed");
        viewPage.clickBackButton();
        Assert.assertTrue(todoItemsPage.isPageOpened(),"To do items page is not opened");
    }
}
