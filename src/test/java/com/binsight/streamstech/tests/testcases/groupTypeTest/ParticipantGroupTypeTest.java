package com.binsight.streamstech.tests.testcases.groupTypeTest;

import com.binsight.streamstech.pages.GroupManagementHomePage;
import com.binsight.streamstech.pages.LoginPage;
import com.binsight.streamstech.pages.groupTypePages.NewGroupTypeCreationSidebarPage;
import com.binsight.streamstech.pages.groupTypePages.ParticipantGroupTypePage;
import com.binsight.streamstech.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParticipantGroupTypeTest extends BaseTest {

    @Test
    public void newGroupTypeSidebarDisplayedSuccessful() {
        page.getInstance(LoginPage.class)
                .getLoginAndRedirectionToGroupManagementHomePage(getUsername(), getPassword());

        NewGroupTypeCreationSidebarPage newGroupTypeCreationSidebarPage = page.getInstance(GroupManagementHomePage.class)
                .clickOnGroupTypesMainMenu()
                .clickOnGroupTypeSubMenu()
                .clickOnGroupTypePlusIcon();

        Assert.assertTrue(newGroupTypeCreationSidebarPage.hasCancelButtonDisplayed());
        Assert.assertTrue(newGroupTypeCreationSidebarPage.hasNewGroupTypeTittleDisplayed());
    }

    @Test
    public void verifyGroupTypeWillNotDeleteIfReferenceHasBeenUsed() {
        page.getInstance(LoginPage.class)
                .getLoginAndRedirectionToGroupManagementHomePage(getUsername(), getPassword());

        page.getInstance(GroupManagementHomePage.class)
                .clickOnGroupTypesMainMenu()
                .clickOnGroupTypeSubMenu()
                .clickOnDeleteIconOfFirstItem()
                .clickOnYesBtnOnAlert();

        Assert.assertTrue(page.getInstance(ParticipantGroupTypePage.class).hasGroupTypeLinkedWithProjectGroupTypeErrorToastMessageDisplayed());
    }


}
