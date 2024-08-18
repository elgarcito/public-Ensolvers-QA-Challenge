package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.FolderPageBase;
import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.ensolvers.carina.example.gui.pages.common.TodoItemsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckManageFolderDirectButtonTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "check delay in manage folder direct button, it is a bug")
    public void checkManageFolderDirectButton(){
        LoginPageBase loginPage=initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Home page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("correctUser"));
        loginPage.typePassword(R.TESTDATA.get("correctPassword"));
        HomePageBase homePage = loginPage.clickSingInButton();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
        FolderPageBase folderPageBase =homePage.clickManageFoldersDirectButton();
        Assert.assertTrue(folderPageBase.isPageOpened(),"Folder page is not opened");
    }
}
