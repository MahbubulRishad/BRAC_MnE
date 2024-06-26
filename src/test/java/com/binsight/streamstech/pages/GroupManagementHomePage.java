package com.binsight.streamstech.pages;

import com.binsight.streamstech.base.BasePage;
import com.binsight.streamstech.pages.groupTypePages.ParticipantGroupTypePage;
import com.binsight.streamstech.utill.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupManagementHomePage extends BasePage {
    public GroupManagementHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean hasGroupWelcomePageTitleDisplayed(){
        return getWebElements(By.xpath("//div//div[@class= 'text-7xl font-bold']")).size() > 0;
    }

    public GroupManagementHomePage clickOnGroupTypesMainMenu(){
       getWebElement(By.xpath("//div//span[normalize-space() = 'Group Types']")).click();
        General.getMiniWaitTime();
       return this;
    }

    public ParticipantGroupTypePage clickOnGroupTypeSubMenu(){
        getWebElement(By.xpath("//span[normalize-space() = 'Group Type']")).click();
        return getInstance(ParticipantGroupTypePage.class);
    }



}
