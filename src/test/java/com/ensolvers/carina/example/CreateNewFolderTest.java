package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.CreateOrEditAFolderPageBase;
import com.ensolvers.carina.example.gui.pages.common.FolderPageBase;
import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewFolderTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "Create a new folder")
    public void createNewFolderTest(){
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
        CreateOrEditAFolderPageBase createOrEditAFolderPage= folderPage.clickCreateNewFolderButton();
        Assert.assertTrue(createOrEditAFolderPage.isPageOpened(),"Create Or Edit A Folder page is not opened");
        createOrEditAFolderPage.typeFolderName(R.TESTDATA.get("folderName"));
        createOrEditAFolderPage.clickSaveButton();
        Assert.assertTrue(folderPage.isPageOpened(),"Folder page is not opened");
        Assert.assertTrue(folderPage.checkCreatedMessageAppear(),"Created message did not appeared");
    }
}
