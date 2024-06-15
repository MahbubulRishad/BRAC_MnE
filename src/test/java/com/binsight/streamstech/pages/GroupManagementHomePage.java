package com.binsight.streamstech.pages;

import com.binsight.streamstech.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupManagementHomePage extends BasePage {
    public GroupManagementHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean hasGroupWelcomePageTitleDisplayed(){
        return getWebElements(By.xpath("//div//div[@class= 'text-7xl font-bold']")).size() > 0;
    }

}
