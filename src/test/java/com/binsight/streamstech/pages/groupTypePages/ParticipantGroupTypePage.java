package com.binsight.streamstech.pages.groupTypePages;

import com.binsight.streamstech.base.BasePage;
import com.binsight.streamstech.utill.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParticipantGroupTypePage extends BasePage {
    public ParticipantGroupTypePage(WebDriver driver) {
        super(driver);
    }

    public boolean hasGroupTypeSubMenuHasDisplayed(){
        return getWebElements(By.xpath("//span[normalize-space() = 'Group Type']")).size() > 0;
    }

    public boolean hasGroupTypeTittleDisplayedOnParticipantGroupTypesPage(){
        return getWebElements(By.xpath("//div//p[normalize-space() = 'Group Type']")).size() > 0;
    }

    public NewGroupTypeCreationSidebarPage clickOnGroupTypePlusIcon(){
        getWebElement(By.xpath("//button//span//mat-icon[normalize-space() = 'add']")).click();
        return getInstance(NewGroupTypeCreationSidebarPage.class);
    }



}
