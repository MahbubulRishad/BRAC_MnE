package com.binsight.streamstech.base;

import com.binsight.streamstech.utill.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement webElement = null;
        try {
            waitForWebElement(locator);
            webElement = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println(locator.toString() + "Not Found");
        }

        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
        List<WebElement> webElements = null;
        try {
            waitForWebElement(locator);
            webElements = driver.findElements(locator);
        } catch (Exception e) {
            System.out.println(locator.toString() + "Not Found");
        }

        return webElements;
    }

    @Override
    public void waitForWebElement(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(locator.toString() + "Not found");
        }
    }

    @Override
    public void tabSwitch() {
        Set<String> allWindows = null;

        String originalWindow = driver.getWindowHandle();

        try {
            allWindows = driver.getWindowHandles();

            // Switch to the new window
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("New Tab not found");
        }
    }

//    public void acceptAlert() {
//        try {
//            wait = new WebDriverWait(driver, Duration.ofSeconds(General.WAIT_TIME));
//            if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
//                System.out.println("Alert is not displayed");
//            } else {
//                driver.switchTo().alert().accept();
//            }
//
//        } catch (Exception e) {
//            System.out.println("Alert Not found");
//        }
//    }


//    public void acceptAlert(){
//
//        Set<String> allPopupWindows = driver.getWindowHandles();
//
//        String originalWindow = driver.getWindowHandle();
//
//
//
//        for (String popup : allPopupWindows){
//            if (!popup.equals(originalWindow)){
//                driver.switchTo().window(popup);
//                WebElement yesElOnPopup = getWebElement(By.xpath("//button//span[@class = 'mat-button-wrapper'][normalize-space() = 'Yes']"));
//                if (yesElOnPopup.isDisplayed()){
//                    yesElOnPopup.click();
//                }
//            }
//        }
////        driver.switchTo().window(originalWindow);
//    }

    public void AlertButton(WebElement locator) {
        Set<String> allPopups = driver.getWindowHandles();
        String popupWindow = driver.getWindowHandle();
//        String originalWindow = driver.getWindowHandle();

        if (allPopups.size() > 1) {
            driver.switchTo().window(popupWindow);

            try {
                WebElement ElOnPopup = locator;
//                yesElOnPopup = getWebElement();

                if (ElOnPopup.isDisplayed()) {
                    ElOnPopup.click();
                }
//                driver.switchTo().window(originalWindow);
            } catch (Exception e) {
                System.out.println("Alert not found");
            }
        }
    }


}
