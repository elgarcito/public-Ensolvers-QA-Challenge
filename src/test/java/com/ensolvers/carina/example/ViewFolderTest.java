package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.FolderPageBase;
import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.ensolvers.carina.example.gui.pages.common.ViewFolderPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewFolderTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "View folder in detail")
    public void viewFolderTest(){
        LoginPageBase loginPage=initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Home page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("correctUser"));
        loginPage.typePassword(R.TESTDATA.get("correctPassword"));
        HomePageBase homePage = loginPage.clickSingInButton();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
        homePage.clickManageListsButton();
        FolderPageBase folderPage= homePage.clickFolderButton();
        Assert.assertTrue(folderPage.isPageOpened(),"Folder page is not opened");
        ViewFolderPageBase viewFolderPage=folderPage.clickViewFolderButton();
        Assert.assertTrue(viewFolderPage.isPageOpened(),"View folder page is not opened");
        Assert.assertTrue(viewFolderPage.checkId(),"ID is not displayed");
        Assert.assertTrue(viewFolderPage.checkName(),"Name is not displayed");
        Assert.assertTrue(viewFolderPage.checkUser(),"User is not displayed");
        viewFolderPage.clickBackButton();
        Assert.assertTrue(folderPage.isPageOpened(),"It doesnt return to folder page");

    }
}
