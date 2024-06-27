package com.binsight.streamstech.tests.testcases.groupTypeTest;

import com.binsight.streamstech.pages.GroupManagementHomePage;
import com.binsight.streamstech.pages.LoginPage;
import com.binsight.streamstech.pages.groupTypePages.NewGroupTypeCreationSidebarPage;
import com.binsight.streamstech.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewGroupTypeCreationSidebarTest extends BaseTest {

    @Test
    public void checkingSaveButtonIsActiveAfterFillGroupTypeName()  {
        page.getInstance(LoginPage.class)
                .getLoginAndRedirectionToGroupManagementHomePage(getUsername(), getPassword());

        NewGroupTypeCreationSidebarPage newGroupTypeCreationSidebarPage = page.getInstance(GroupManagementHomePage.class)
                .clickOnGroupTypesMainMenu()
                .clickOnGroupTypeSubMenu()
                .clickOnGroupTypePlusIcon()
                .fillGroupType(getGroupType());

        Assert.assertTrue(newGroupTypeCreationSidebarPage.isSaveButtonActivatedAfterFillGroupTypeName());

    }

}
