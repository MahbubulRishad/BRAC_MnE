package com.binsight.streamstech.pages;

import com.binsight.streamstech.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUsername(String username) {
        getWebElement(By.cssSelector("#email")).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        getWebElement(By.cssSelector("#password")).sendKeys(password);
        return this;
    }

    public HomeModuleListPage clickLoginBtn() {
        getWebElement(By.xpath("//span//span[normalize-space()='Sign in']")).click();
        return getInstance(HomeModuleListPage.class);
    }

    public LoginPage clickLoginBtnError(){
        getWebElement(By.xpath("//span//span[normalize-space()='Sign in']")).click();
        return this;
    }

    public boolean hasUsernameInputFieldError() {
        return getWebElements(By.xpath("//div//div//mat-error[normalize-space() = 'Username is required']")).size() > 0;
    }

    public boolean hasPasswordInputFieldError() {
        return getWebElements(By.xpath("//div//div//mat-error[normalize-space() = 'Password is required']")).size() > 0;
    }


    public boolean hasBothUsernamePasswordInputFieldsError() {
        return (getWebElements(By.xpath("//div//div//mat-error[normalize-space() = 'Password is required']")).size() > 0 &
                getWebElements(By.xpath("//div//div//mat-error[normalize-space() = 'Username is required']")).size() > 0);
    }

    public boolean hasErrorMessageForWrongUsernameOrPassword(){
        return  getWebElements(By.xpath("//div[@class='fuse-alert-message ng-tns-c48-3']")).size() > 0;
    }

}
