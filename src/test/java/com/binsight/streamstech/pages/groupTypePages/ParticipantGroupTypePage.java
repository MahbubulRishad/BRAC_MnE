package com.binsight.streamstech.pages.groupTypePages;

import com.binsight.streamstech.base.BasePage;
import com.binsight.streamstech.utill.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

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

    public boolean hasSavedSuccessfulToastMessageAppeared(){
        return getWebElements(By.xpath("//div//div[normalize-space() = 'Saved Successfully']")).size() > 0;
    }


    public ParticipantGroupTypePage clickOnDeleteIconOfFirstItem(){
        getWebElement(By.xpath("(//mat-icon[@role = 'img'][normalize-space() = 'delete'])[1]")).click();
        return this;
    }

    public void acceptAlert() {
        Set<String> allPopups = driver.getWindowHandles();
        String popupWindow = driver.getWindowHandle();
        String originalWindow = driver.getWindowHandle();

        if (allPopups.size() > 1){
            driver.switchTo().window(popupWindow);

            try{
                WebElement yesElOnPopup = getWebElement(By.xpath("//button//span[@class = 'mat-button-wrapper'][normalize-space() = 'Yes']"));

                if (yesElOnPopup.isDisplayed()){
                    yesElOnPopup.click();
                }
//                driver.switchTo().window(originalWindow);
            }catch (Exception e){
                System.out.println("Alert not found");
            }
        }
    }

//    public void clickOnYesButtonOfAlertMessage(){
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//    }

//    public void clickOnCancelButtonOfAlertMessage(){
//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();
//    }

    public boolean hasGroupTypeLinkedWithProjectGroupTypeErrorToastMessageDisplayed(){
        General.getLinkLoadTime();
        return getWebElements(By.xpath("//div[normalize-space() = 'This ParticipantGroupType cannot be deleted because it is linked with project_group_type_setting']")).size() > 0;
    }

//    public boolean isSavedSuccessfulToastMessageAppeared2(){
//        boolean ParticipantGroupTypePage = false;
//        return ParticipantGroupTypePage;
//    }

//    public boolean hasSavedSuccessfulToastMessageAppeared3() {
//        WebElement toastMessage = null;
//        try {
//            // Assuming the toast message has a specific class or id
//            toastMessage = getWebElement(By.xpath("//div//div[normalize-space() = 'Saved Successfully']"));
//            // You can add more checks here if needed, e.g., text content of the toast
//            return toastMessage.isDisplayed();
//        } catch (Exception e) {
//            // If no such element is found or any other exception occurs, return false
//            return false;
//        }
//    }



}
