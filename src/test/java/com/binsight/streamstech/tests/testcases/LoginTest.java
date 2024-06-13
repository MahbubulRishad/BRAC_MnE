package com.binsight.streamstech.tests.testcases;

import com.binsight.streamstech.base.Page;
import com.binsight.streamstech.pages.HomeModuleListPage;
import com.binsight.streamstech.pages.LoginPage;
import com.binsight.streamstech.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginShouldBeSuccessful() {
        HomeModuleListPage homeModuleListPage = page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();

        Assert.assertTrue(homeModuleListPage.hasUserLogo());
    }

    @Test
    public void LoginShouldBeFailedForOnlyUsername() {
        LoginPage loginPage = page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .clickLoginBtnError();

        Assert.assertTrue(loginPage.hasPasswordInputFieldError());
    }

    @Test
    public void LoginShouldBeFailedForOnlyPassword() {
        LoginPage loginPage = page.getInstance(LoginPage.class)
                .fillPassword(getPassword())
                .clickLoginBtnError();

        Assert.assertTrue(loginPage.hasUsernameInputFieldError());
    }

    @Test
    public void LoginShouldBeFailedForNotProvidingAnyUsernameAndPassword() {
        LoginPage loginPage = page.getInstance(LoginPage.class)
                .clickLoginBtnError();

        Assert.assertTrue(loginPage.hasBothUsernamePasswordInputFieldsError());
    }

    @Test
    public void LoginShouldBeFailedForWrongUserNameOrPassword(){
        LoginPage loginPage = page.getInstance(LoginPage.class)
                .fillUsername("ABC")
                .fillPassword("abc")
                .clickLoginBtnError();

        Assert.assertTrue(loginPage.hasErrorMessageForWrongUsernameOrPassword());
    }

}
