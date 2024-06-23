package com.binsight.streamstech.tests.testcases;

import com.binsight.streamstech.pages.GroupManagementHomePage;
import com.binsight.streamstech.pages.LoginPage;
import com.binsight.streamstech.tests.base.BaseTest;
import com.binsight.streamstech.utill.General;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HomeModuleListTest extends BaseTest {

    @Test
    public void clickOnGroupManagementModuleAndCheckRedirection() {
        GroupManagementHomePage groupManagementHomePage = page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickOnGroupManagementModule();


        // Tab switch
        page.tabSwitch();
        // tab switch function that is created in Page Class

//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get(General.GROUP_MANAGEMENT_HOME_PAGE);

//        ArrayList<String> newTab = page.tabSwitch();

        Assert.assertEquals(groupManagementHomePage.getCurrentUrl(), General.GROUP_MANAGEMENT_HOME_PAGE);
        Assert.assertTrue(groupManagementHomePage.hasGroupWelcomePageTitleDisplayed());
    }
}
