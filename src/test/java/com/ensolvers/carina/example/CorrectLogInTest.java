package com.ensolvers.carina.example;

import com.ensolvers.carina.example.gui.pages.common.HomePageBase;
import com.ensolvers.carina.example.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CorrectLogInTest implements IAbstractTest {

    @MethodOwner(owner = "edgar")
    @Test(description = "Correct Sign In")
    public void testCorrectLogIn(){
        LoginPageBase loginPage=initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Home page is not opened");
        loginPage.typeUsername(R.TESTDATA.get("correctUser"));
        loginPage.typePassword(R.TESTDATA.get("correctPassword"));
        HomePageBase homePage = loginPage.clickSingInButton();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
    }
}
