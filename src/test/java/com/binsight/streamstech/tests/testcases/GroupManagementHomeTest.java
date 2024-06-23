package com.binsight.streamstech.tests.testcases;

import com.binsight.streamstech.pages.GroupManagementHomePage;
import com.binsight.streamstech.pages.HomeModuleListPage;
import com.binsight.streamstech.pages.LoginPage;
import com.binsight.streamstech.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupManagementHomeTest extends BaseTest {

    @Test
    public void GroupTypeSubMenuHasDisplayedUnderGroupTypeMenu() {
        GroupManagementHomePage groupManagementHomePage = page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickOnGroupManagementModule();
        page.tabSwitch();

        GroupManagementHomePage groupManagementHomePage1 = page.getInstance(GroupManagementHomePage.class)
                .clickOnGroupTypesMainMenu()
                .clickOnGroupTypeSubMenu();

        Assert.assertTrue(groupManagementHomePage1.hasGroupTypeSubMenuHasDisplayed());

    }

    @Test
    public void GroupTypeSubMenuHasDisplayedUnderGroupTypeMenu2(){
        page.getInstance(LoginPage.class)   // calling common method login and redirection
                .getLoginAndRedirectionToGroupManagementHomePage(getUsername(), getPassword());

        GroupManagementHomePage groupManagementHomePage = page.getInstance(GroupManagementHomePage.class)
                .clickOnGroupTypesMainMenu()
                .clickOnGroupTypeSubMenu();

        Assert.assertTrue(groupManagementHomePage.hasGroupTypeSubMenuHasDisplayed());

    }

}
