package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditAFolderTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "Edit a previously created folder")
    public void editAFolderTest(){
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
        CreateOrEditAFolderPageBase createOrEditAFolderEditPage= folderPage.clickEditFolderButton();
        Assert.assertTrue(createOrEditAFolderEditPage.isPageOpened(),"Create or edit a folder page is not opened");
        createOrEditAFolderEditPage.typeFolderName(R.TESTDATA.get("newFolderName"));
        createOrEditAFolderEditPage.clickSaveButton();
        pause(3);
        Assert.assertTrue(folderPage.checkUpdatedMessageAppear(),"Updated folder message not appeared");
    }
}
