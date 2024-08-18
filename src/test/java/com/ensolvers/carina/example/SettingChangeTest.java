package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.ensolvers.carina.example.gui.pages.common.UserSettingForUserPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingChangeTest implements IAbstractTest {
    @MethodOwner(owner = "edgar")
    @Test(description = "Change setting test")
    public void settingChangeTest(){
        LoginPageBase loginPage=initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Home page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("correctUser"));
        loginPage.typePassword(R.TESTDATA.get("correctPassword"));
        HomePageBase homePage = loginPage.clickSingInButton();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
        homePage.clickAccountButton();
        UserSettingForUserPageBase userSettingForUserPage= homePage.clickSettingButton();
        Assert.assertTrue(userSettingForUserPage.isPageOpened(),"User Setting For User Page is not opened");
        userSettingForUserPage.typeFirstName(R.TESTDATA.get("firstName"));
        userSettingForUserPage.typeLastName(R.TESTDATA.get("lastName"));
        userSettingForUserPage.typeEmail(R.TESTDATA.get("email"));
        userSettingForUserPage.clickSaveButton();
        Assert.assertTrue(userSettingForUserPage.checkSettingSaveMessage(),"Saved message is not displayed");

    }
}
