package com.binsight.streamstech.pages;

import com.binsight.streamstech.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeModuleListPage extends BasePage {
    public HomeModuleListPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasUserLogo(){
        return getWebElements(By.xpath("//span[@class='relative']")).size() > 0;
    }

    public GroupManagementHomePage clickOnGroupManagementModule() {
        getWebElement(By.xpath("//div//p[normalize-space() = 'Group Management']")).click();
        return getInstance(GroupManagementHomePage.class);
    }
}
