package com.binsight.streamstech.pages.groupTypePages;

import com.binsight.streamstech.base.BasePage;
import com.binsight.streamstech.utill.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewGroupTypeCreationSidebarPage extends BasePage {
    public NewGroupTypeCreationSidebarPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasCancelButtonDisplayed() {
        return getWebElements(By.xpath("//button//span[normalize-space() = 'Cancel']")).size() > 0;
    }

    public boolean hasNewGroupTypeTittleDisplayed() {
        return getWebElements(By.xpath("//div[normalize-space() = 'New Group Type']")).size() > 0;
    }

    public NewGroupTypeCreationSidebarPage fillGroupType(String groupTypename)  {
        getWebElement(By.xpath("//div//input[@id = 'mat-input-1']")).sendKeys(groupTypename);
        return this;
    }

    public boolean isSaveButtonActivatedAfterFillGroupTypeName() {
        return getWebElements(By.xpath("//button[@type='submit' and @class = 'mat-focus-indicator px-6 ml-3 mat-flat-button mat-button-base mat-primary']")).size() > 0;
    }


}
