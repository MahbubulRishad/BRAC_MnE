package com.binsight.streamstech.pages;

import com.binsight.streamstech.base.BasePage;
import com.binsight.streamstech.base.Page;
import com.binsight.streamstech.utill.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeModuleListPage extends BasePage {
    BasePage basePage;
    LoginPage loginPage;

    public HomeModuleListPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasUserLogo(){
        return getWebElements(By.xpath("//span[@class='relative']")).size() > 0;
    }

    public GroupManagementHomePage clickOnGroupManagementModule() {
        getWebElement(By.xpath("//div//p[normalize-space() = 'Group Management']")).click();
        General.getLinkLoadTime();
        return getInstance(GroupManagementHomePage.class);
    }

    public void clickOnGroupManagementModuleAndRedirectedToGroupManagementHomePage(){
        clickOnGroupManagementModule();
        tabSwitch();
    }
}
