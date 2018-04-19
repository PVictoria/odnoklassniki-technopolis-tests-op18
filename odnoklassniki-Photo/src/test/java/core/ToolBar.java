package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolBar extends HelperBase {
    WebElement element;
    public ToolBar(WebDriver driver) {
       super(driver);
       element =  driver.findElement(By.id("mainTopContentRow"));

    }
    public void check(){

    }


//    public PhotoMainPage openPhotoMainPage(){
//        WebElement webElement = element.findElement(By.xpath("/descendant::*[contains(@href, 'photos')]"));
//        if(webElement.isDisplayed()) {
//            webElement.click();
//        }
//            return new PhotoMainPage(driver);
//
//    }
}
